package com.alfianyusufabdullah.indonesiancurrency

import java.text.DecimalFormat

/**
 * Created by jonesrandom on 3/13/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 *
 */
class IndonesianCurrency(Amount: Double) {

    private var amount: Double = Amount
    private var iso: String = ""
    private var isWrap: Boolean = false

    fun withRP(space: Boolean): IndonesianCurrency {
        iso = if (space) "Rp. " else "Rp."
        return this
    }

    fun withIDR(space: Boolean): IndonesianCurrency {
        iso = if (space) "IDR " else "IDR"
        return this
    }

    fun wrap(): IndonesianCurrency {
        isWrap = true
        return this
    }

    fun parse(): String {

        if (amount in 1..999) {
            return iso +  DecimalFormat("0.#").format(amount)
        } else {
            if (isWrap) {

                val simb = getWrapStat(amount)
                val currency = amount / count(amount)

                return if (simb == " Ribu" && currency == 1.0) {
                    "Seribu"
                } else {
                    val df = DecimalFormat("0.###").format(currency)
                    "$iso$df$simb"
                }
            } else {
                val raw = DecimalFormat("0.#").format(amount)
                return when (raw.length) {
                    4 -> {
                        val a = raw.substring(0, 1)
                        val b = raw.substring(1, 4)
                        "$iso$a.$b"
                    }
                    5 -> {
                        val a = raw.substring(0, 2)
                        val b = raw.substring(2, 5)
                        "$iso$a.$b"
                    }
                    6 -> {
                        val a = raw.substring(0, 3)
                        val b = raw.substring(3, 6)
                        "$iso$a.$b"
                    }
                    7 -> {
                        val a = raw.substring(0, 1)
                        val b = raw.substring(1, 4)
                        val c = raw.substring(4, 7)
                        "$iso$a.$b.$c"
                    }
                    8 -> {
                        val a = raw.substring(0, 2)
                        val b = raw.substring(2, 5)
                        val c = raw.substring(5, 8)
                        "$iso$a.$b.$c"
                    }
                    9 -> {
                        val a = raw.substring(0, 3)
                        val b = raw.substring(3, 6)
                        val c = raw.substring(6, 9)
                        "$iso$a.$b.$c"
                    }
                    10 -> {
                        val a = raw.substring(0, 1)
                        val b = raw.substring(1, 4)
                        val c = raw.substring(4, 7)
                        val d = raw.substring(7, 10)
                        "$iso$a.$b.$c.$d"
                    }
                    11 -> {
                        val a = raw.substring(0, 2)
                        val b = raw.substring(2, 5)
                        val c = raw.substring(5, 8)
                        val d = raw.substring(8, 11)
                        "$iso$a.$b.$c.$d"
                    }
                    12 -> {
                        val a = raw.substring(0, 3)
                        val b = raw.substring(3, 6)
                        val c = raw.substring(6, 9)
                        val d = raw.substring(9, 12)
                        "$iso$a.$b.$c.$d"
                    }
                    else -> {
                        raw
                    }
                }
            }
        }
    }

    private fun count(amount: Double): Double {
        val df = DecimalFormat("0.#")
        val amp = df.format(amount)

        return when {
            amp.length in 4..6 -> 1000.0
            amp.length in 6..9 -> 1000000.0
            amp.length in 9..12 -> 1000000000.0
            amp.length in 12..15 -> 1000000000000.0
            else -> {
                100.0
            }
        }
    }

    private fun getWrapStat(amount: Double): String {
        val df = DecimalFormat("0.#")
        val amp = df.format(amount)

        return when {
            amp.length in 4..6 -> " Ribu"
            amp.length in 6..9 -> " Juta"
            amp.length in 9..12 -> " Milliar"
            amp.length in 12..15 -> " Triliun"
            else -> {
                ""
            }
        }
    }

}