import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RomanNumerals {
    public final List<String> THINGS = Arrays.asList("I", "V", "X", "L", "C", "D", "M", "?", "?");
    {
        Collections.reverse(THINGS);
    }

    public int getMultiplier(int offset) {
        int result =   1;
        for (int index = 8 - offset; index > 0; index-=2) {
            result*=10;
        }
        return result;
    }


    public String getRomanStringOne(int i) {
        return THINGS.get(i);
    }

    public String getRomanStringFour(int i) {
        return THINGS.get(i) + THINGS.get(i - 1);
    }

    public String getRomanStringFive(int i) {
        return THINGS.get(i - 1);
    }

    public String getRomanStringNine(int i) {
        return THINGS.get(i) + THINGS.get(i - 2);
    }
}