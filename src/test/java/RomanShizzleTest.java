import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanShizzleTest {

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "40,XL"
    })
    public void number_maps_to_roman_numeral(int decimal, String roman) {
        // WHEN
        String result = RomanShizzle.of(decimal);

        // THEN
        assertEquals(roman, result);
    }
}
