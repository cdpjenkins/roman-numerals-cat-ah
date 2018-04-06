public class RomanShizzle {
    public static String of(int arabicNumber) {
        StringBuffer result = new StringBuffer();

        arabicNumber = consumeNumber(arabicNumber, result, 100, "C");
        arabicNumber = consumeNumber(arabicNumber, result, 90, "XC");
        arabicNumber = consumeNumber(arabicNumber, result, 50, "L");
        arabicNumber = consumeNumber(arabicNumber, result, 40, "XL");
        arabicNumber = consumeNumber(arabicNumber, result, 10, "X");
        arabicNumber = consumeNumber(arabicNumber, result, 9, "IX");
        arabicNumber = consumeNumber(arabicNumber, result, 5, "V");
        arabicNumber = consumeNumber(arabicNumber, result, 4, "IV");
        consumeNumber(arabicNumber, result, 1, "I");


        return result.toString();
    }

    private static int consumeNumber(int arabicNotDecimalShizzle, StringBuffer result, int i, String ix) {
        while (arabicNotDecimalShizzle >= i) {
            result.append(ix);
            arabicNotDecimalShizzle -= i;
        }
        return arabicNotDecimalShizzle;
    }
}
