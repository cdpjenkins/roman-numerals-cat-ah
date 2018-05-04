
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {
    @ParameterizedTest
    @CsvSource({
            "2,1000",
            "4,100",
            "6,10",
            "8,1"
    })
    void multiplier_is(int index, int expectedMultiplier) {
        RomanNumerals romanNumerals = new RomanNumerals();
        assertEquals(expectedMultiplier, romanNumerals.getMultiplier(index));
    }
}