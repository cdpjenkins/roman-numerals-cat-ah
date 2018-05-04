public class RomanShizzle {

    public final RomanNumerals romanNumerals = new RomanNumerals();



    public String of(int number) {
        StringBuffer result = new StringBuffer();

        number = solveBaseNumbers(number, result, 2);
        number = solveBaseNumbers(number, result, 4);
        number = solveBaseNumbers(number, result, 6);
        solveBaseNumbers(number, result, 8);

        return result.toString();
    }

    private int solveBaseNumbers(int number, StringBuffer result, int i) {

        int multiplier = romanNumerals.getMultiplier(i);
        number = consumeNumber(number, result, 9 * multiplier, romanNumerals.THINGS.get(i) + romanNumerals.THINGS.get(i-2));
        number = consumeNumber(number, result, 5 * multiplier, romanNumerals.THINGS.get(i-1));
        number = consumeNumber(number, result, 4 * multiplier, romanNumerals.THINGS.get(i) + romanNumerals.THINGS.get(i-1));
        number = consumeNumber(number, result, 1 * multiplier, romanNumerals.THINGS.get(i));

        return number;
    }

    private int consumeNumber(int number, StringBuffer result, int i, String romanString) {
        while (number >= i) {
            result.append(romanString);
            number -= i;
        }
        return number;
    }
}