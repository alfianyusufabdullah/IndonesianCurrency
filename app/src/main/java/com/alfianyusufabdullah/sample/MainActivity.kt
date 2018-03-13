package com.alfianyusufabdullah.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alfianyusufabdullah.indonesiancurrency.IndonesianCurrency
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isIsoEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swIso.setOnCheckedChangeListener { _, isChecked ->
            isIsoEnabled = isChecked

            rbRP.isEnabled = isChecked
            rbIDR.isEnabled = isChecked
        }

        btnParse.setOnClickListener {
            val amount = etAmount.text.toString()
            if (amount.isEmpty()) {
                tvResult.text = "0"
                return@setOnClickListener
            }

            val res = IndonesianCurrency(amount.toDouble())
            if (isIsoEnabled) {
                when (rgIso.checkedRadioButtonId) {
                    R.id.rbIDR -> res.withIDR(true)
                    R.id.rbRP -> res.withRP(true)
                }
            }

            if (chWrap.isChecked) {
                res.wrap()
            }

            tvResult.text = res.parse()
        }
    }
}
