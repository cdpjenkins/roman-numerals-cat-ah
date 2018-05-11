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
        romanSum = consumeNumber(romanSum, 9 * multiplier, romanNumerals.getRomanStringNine(i));
        romanSum = consumeNumber(romanSum, 5 * multiplier, romanNumerals.getRomanStringFive(i));
        romanSum = consumeNumber(romanSum, 4 * multiplier, romanNumerals.getRomanStringFour(i));
        romanSum = consumeNumber(romanSum, 1 * multiplier, romanNumerals.getRomanStringOne(i));

        return romanSum.getNumber();
    }


    private RomanSum consumeNumber(RomanSum romanSum, int i, String romanString) {
        while (romanSum.getNumber() >= i) {
            romanSum.getResult().append(romanString);
            romanSum.setNumber(romanSum.getNumber() - i);
        }
        return romanSum;
    }
}