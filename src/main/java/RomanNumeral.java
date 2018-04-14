import static java.util.Objects.nonNull;

enum RomanNumeral {
    I(1),
    V(5, I),
    X(10, I),
    L(50, X),
    C(100, X),
    D(500, C),
    M(1000, C);

    private int value;
    private RomanNumeral negativeModifier;

    public int getValue() {
        return value;
    }

    public boolean hasNegativeModifier() {
        return nonNull(negativeModifier);
    }

    public int lesserValue() {
        return value - negativeModifier.value;
    }

    public String lesserString() {
        return negativeModifier.toString() + toString();
    }

    RomanNumeral(int value) {
        this.value = value;
    }

    RomanNumeral(int value, RomanNumeral negativeModifier) {
        this.value = value;
        this.negativeModifier = negativeModifier;
    }
}
