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

        number = solveBaseNumbers(number, result, 2, 1000);
        number = solveBaseNumbers(number, result, 4, 100);
        number = solveBaseNumbers(number, result, 6, 10);
        solveBaseNumbers(number, result, 8, 1);

        return result.toString();
    }

    private static int solveBaseNumbers(int number, StringBuffer result, int i, int multiplier) {

        number = consumeNumber(number, result, 9 * multiplier, THINGS.get(i) + THINGS.get(i-2));
        number = consumeNumber(number, result, 5 * multiplier, THINGS.get(i-1));
        number = consumeNumber(number, result, 4 * multiplier, THINGS.get(i) + THINGS.get(i-1));
        number = consumeNumber(number, result, 1 * multiplier, THINGS.get(i));

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