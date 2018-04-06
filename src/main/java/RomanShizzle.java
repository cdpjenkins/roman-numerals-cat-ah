public class RomanShizzle {
    public static String of(int arabicNotDecimalShizzle) {
        StringBuffer result = new StringBuffer("");

        arabicNotDecimalShizzle = getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 40, "XL");
        arabicNotDecimalShizzle = getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 10, "X");
        arabicNotDecimalShizzle = getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 9, "IX");
        arabicNotDecimalShizzle = getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 5, "V");
        arabicNotDecimalShizzle = getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 4, "IV");
        getArabicNotDecimalShizzle(arabicNotDecimalShizzle, result, 1, "I");


        return result.toString();
    }

    private static int getArabicNotDecimalShizzle(int arabicNotDecimalShizzle, StringBuffer result, int i, String ix) {
        while (arabicNotDecimalShizzle >= i) {
            result.append(ix);
            arabicNotDecimalShizzle -= i;
        }
        return arabicNotDecimalShizzle;
    }
}
