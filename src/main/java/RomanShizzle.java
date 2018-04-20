import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanShizzle {
    public static String of(int number) {
        StringBuffer result = new StringBuffer();

        List<String> things = Arrays.asList("I", "V", "X", "L", "C", "D", "M", "?", "?");
        Collections.reverse(things);

        number = solveBaseNumbers(number, result, things.get(2), things.get(1), things.get(0), 1000);
        number = solveBaseNumbers(number, result, things.get(4), things.get(3), things.get(2), 100);
        number = solveBaseNumbers(number, result, things.get(6), things.get(5), things.get(4), 10);
        solveBaseNumbers(number, result, things.get(8), things.get(7), things.get(6), 1);

        return result.toString();
    }

    private static int solveBaseNumbers(int number, StringBuffer result, String i, String v, String x, int multiplier) {

        number = consumeNumber(number, result, 9 * multiplier, i + x);
        number = consumeNumber(number, result, 5 * multiplier, v);
        number = consumeNumber(number, result, 4 * multiplier, i + v);
        number = consumeNumber(number, result, 1 * multiplier, i);

        return number;
    }

    private static int consumeNumber(int number, StringBuffer result, int i, String romanString) {
        while (number >= i) {
            result.append(romanString);
            number -= i;
        }
        return number;
    }
}