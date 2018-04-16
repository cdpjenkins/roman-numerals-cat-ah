internal enum class KRomanNumeral(val value: Int, var negativeModifier: KRomanNumeral? = null) {
    I(1),
    V(5, I),
    X(10, I),
    L(50, X),
    C(100, X),
    D(500, C),
    M(1000, C);

    fun lesserValue() = value - negativeModifier!!.value
    fun lesserString() = negativeModifier.toString() + toString()
}
