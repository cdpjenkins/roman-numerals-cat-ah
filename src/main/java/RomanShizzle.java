import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanShizzle {

    static class Result {
        private int number;
        private String letters;

        public Result(int number, String letters) {
            this.number = number;
            this.letters = letters;
        }
    }

    public static String of(int number) {
        StringBuilder builder = new StringBuilder();

        List<RomanNumeral> romanNumerals = Stream.of(RomanNumeral.values())
                .sorted(Comparator.comparing(RomanNumeral::getValue).reversed())
                .collect(Collectors.toList());

        for (RomanNumeral romanNumeral : romanNumerals) {
            Result result = consumeNumber(number, "", romanNumeral);
            number = result.number;
            builder.append(result.letters);

            // no need to loop if we're done consuming the numbers
            if (number == 0) {
                break;
            }
        }

        return builder.toString();
    }

    private static Result consumeNumber(int number, String letters, RomanNumeral romanNumeral) {
        if (number >= romanNumeral.getValue()) {
            return consumeNumber(number - romanNumeral.getValue(),
                    letters + romanNumeral.toString(), romanNumeral);
        } else if (romanNumeral.hasNegativeModifier()
                && number >= romanNumeral.lesserValue()) {
            return consumeNumber(number - romanNumeral.lesserValue(),
                    letters + romanNumeral.lesserString(), romanNumeral);
        }

        return new Result(number, letters);
    }
}