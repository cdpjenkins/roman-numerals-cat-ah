import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanShizzle {
    
    public static final List<String> THINGS =Arrays.asList("I", "V", "X", "L", "C", "D", "M", "?", "?");
    static {
        Collections.reverse(THINGS);
    }

    public static String of(int number) {
        StringBuffer result = new StringBuffer();

        number = solveBaseNumbers(number, result, THINGS.get(2), THINGS.get(1), THINGS.get(0), 1000);
        number = solveBaseNumbers(number, result, THINGS.get(4), THINGS.get(3), THINGS.get(2), 100);
        number = solveBaseNumbers(number, result, THINGS.get(6), THINGS.get(5), THINGS.get(4), 10);
        solveBaseNumbers(number, result, THINGS.get(8), THINGS.get(7), THINGS.get(6), 1);

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