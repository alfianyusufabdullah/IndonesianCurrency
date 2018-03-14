# Indonesia Currency Converter

## Add Dependencies

1. Add it in your root **build.gradle** at the end of repositories:
```gradle
repositories {
 ...
  maven { url 'https://jitpack.io' }
}
```
2. on module app **build.gradle** 
```gradle
implementation 'com.github.alfianyusufabdullah:IndonesianCurrency:0.0.1'
```
## How To Use
```java
/// 1.000.000
double amount = ...
String result = new IndonesianCurrency(amount).parse();
```

```java
///Rp. 1.000.000
double amount = ...
String result = new IndonesianCurrency(amount).withRP(true).parse();
```

```java
///IDR 1.000.000
double amount = ...
String result = new IndonesianCurrency(amount).withIDR(true).parse();
```

```java
///Rp. 1 Juta
double amount = ...
String result = new IndonesianCurrency(amount).withRP(true).wrap().parse();
```

```java
///IDR 1 Juta
double amount = ...
String result = new IndonesianCurrency(amount).withIDR(true).wrap().parse();
```

```java
///1 Juta
double amount = ...
String result = new IndonesianCurrency(amount).wrap().parse();
```

## Sample Preview
<img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss1.png" width="250"> <img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss2.png" width="250"> <img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss3.png" width="250"> <img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss4.png" width="250"> <img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss6.png" width="250"> <img src="https://github.com/alfianyusufabdullah/IndonesianCurrency/raw/master/app/preview/ss5.png" width="250">
