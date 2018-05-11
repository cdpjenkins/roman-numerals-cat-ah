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
            "40,XL",
            "41,XLI",
            "50,L",
            "90,XC",
            "100,C",
            "3000,MMM",
    })
    public void number_maps_to_roman_numeral(int decimal, String roman) {
        // WHEN
        String result = new RomanShizzle().of(decimal);

        // THEN
        assertEquals(roman, result);
    }

    @ParameterizedTest
    @CsvSource({
            "I,1",
            "II,2",
            "III,3",
            "IV,4",
            "V,5"

    })
    public void roman_numeral_maps_to_number(String roman, int number) {
        // WHEN
        int result = new RomanShizzle().toNumber(roman);

        // THEN
        assertEquals(number, result);
    }
}
