/**
 * Created by brettcoomer on 2017/01/25.
 */
class StringCalculator() {

    fun Add(numbers: String) : Int {

        if (numbers.isEmpty()) return 0

        var numberString = numbers
        var delimiters : Array<String> = arrayOf(",","\n")

        if (numberString.startsWith("//[")) {

            numberString.slice(0..numberString.indexOf('\n')-1).split("][").forEach({
                it -> delimiters = delimiters.plus(it.replace("/|\\]|\\[".toRegex(),""))
            })

            val bracketIndex = numbers.lastIndexOf(']')
            numberString = numberString.substring(bracketIndex+2)

        } else if (numberString.startsWith("//")) {
            delimiters = delimiters.plus(numbers.slice(2..2))
            numberString = numberString.substring(4)
        }

        return numberString.split(*delimiters).map{
            if (it.toInt() < 0)
                throw NumberFormatException("Negatives not allowed")
            it.toInt()
        }.filter{
            it <= 1000
        }.sumBy{
            it
        }
    }
}