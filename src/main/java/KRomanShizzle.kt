import java.util.Objects.nonNull

object KRomanShizzle {

    fun of(inputNumber: Int): String {
        var number = inputNumber

        val romanNumerals = KRomanNumeral.values()
                .sortedByDescending { it.value }
                .toList()

        return romanNumerals
                .takeWhile { number > 0 }
                .fold("", { currentString, romanNumeral ->
                    val (newNumber, letters) = consumeNumber(number, "", romanNumeral)
                    number = newNumber
                    currentString + letters
                })

    }

    private tailrec fun consumeNumber(number: Int, letters: String, romanNumeral: KRomanNumeral): Pair<Int, String> {
        val canConsume = number >= romanNumeral.value
        val lesserValueCanConsume = nonNull(romanNumeral.negativeModifier) && number >= romanNumeral.lesserValue()

        return when {
            canConsume -> consumeNumber(number - romanNumeral.value,
                    letters + romanNumeral.toString(), romanNumeral)
            lesserValueCanConsume -> consumeNumber(number - romanNumeral.lesserValue(),
                    letters + romanNumeral.lesserString(), romanNumeral)
            else -> Pair(number, letters)
        }
    }

    fun of(romanNumeral: String): Int {
        val (convertedNumber, _) = romanNumeral.fold(Pair(0, 0), { sumAndPrevious, numeral ->
            val (sum, previousNumber) = sumAndPrevious
            val currentNumber = numeral.toNumber()
            val newSum = when (currentNumber > previousNumber) {
                true -> sum + currentNumber - 2 * previousNumber
                else -> sum + currentNumber
            }

            Pair(newSum, currentNumber)
        })
        return convertedNumber
    }

    private fun Char.toNumber(): Int {
        return when (this) {
            'M' -> 1000
            'D' -> 500
            'C' -> 100
            'L' -> 50
            'X' -> 10
            'V' -> 5
            else -> 1
        }
    }
}