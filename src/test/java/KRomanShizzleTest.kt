

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KRomanShizzleTest {

    @ParameterizedTest
    @CsvSource(
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
            "448,CDXLVIII",
            "1473,MCDLXXIII",
            "3000,MMM",
            "3255,MMMCCLV")
    fun number_maps_to_roman_numeral(decimal: Int, roman: String) {
        // WHEN
        val result = KRomanShizzle.of(decimal)

        // THEN
        assertEquals(roman, result)
    }
}
