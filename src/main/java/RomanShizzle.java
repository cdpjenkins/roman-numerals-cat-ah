import blah.RomanSum;

public class RomanShizzle {

    public final RomanNumerals romanNumerals = new RomanNumerals();



    public String of(int number) {
        StringBuffer result = new StringBuffer();

        number = solveBaseNumbers(new RomanSum(number, result), 2);
        number = solveBaseNumbers(new RomanSum(number, result), 4);
        number = solveBaseNumbers(new RomanSum(number, result), 6);
        solveBaseNumbers(new RomanSum(number, result), 8);

        return result.toString();
    }

    private int solveBaseNumbers(RomanSum romanSum, int i) {

        int multiplier = romanNumerals.getMultiplier(i);
        romanSum.setNumber(consumeNumber(romanSum.getNumber(), romanSum.getResult(), 9 * multiplier, romanNumerals.THINGS.get(i) + romanNumerals.THINGS.get(i - 2)));
        romanSum.setNumber(consumeNumber(romanSum.getNumber(), romanSum.getResult(), 5 * multiplier, romanNumerals.THINGS.get(i - 1)));
        romanSum.setNumber(consumeNumber(romanSum.getNumber(), romanSum.getResult(), 4 * multiplier, romanNumerals.THINGS.get(i) + romanNumerals.THINGS.get(i - 1)));
        romanSum.setNumber(consumeNumber(romanSum.getNumber(), romanSum.getResult(), 1 * multiplier, romanNumerals.THINGS.get(i)));

        return romanSum.getNumber();
    }

    private int consumeNumber(int number, StringBuffer result, int i, String romanString) {
        while (number >= i) {
            result.append(romanString);
            number -= i;
        }
        return number;
    }
}