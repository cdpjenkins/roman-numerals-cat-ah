import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanShizzle {
    public static String of(int number) {
        StringBuffer result = new StringBuffer();

        List<String> things = Arrays.asList("I", "V", "X", "L", "C", "D", "M", "?", "?");
        Collections.reverse(things);

        int multiplier = 1000;
        for (int i = 0; i < things.size() - 2 ; i += 2) {
            number = solveBaseNumbers(number, result, things.get(i + 2), things.get(i + 1), things.get(i), multiplier);
            multiplier /= 10;
        }

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