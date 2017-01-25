/**
 * Created by brettcoomer on 2017/01/25.
 */
class StringCalculator() {

    fun getDelimiters(numberString: String) : Array<String> {
        var result = Array<String>(0,{i->""})
        numberString.slice(0..numberString.indexOf('\n')-1).split("][").forEach({
            it -> result = result.plus(it.replace("/|\\]|\\[".toRegex(),""))
        })
        return result
    }

    fun Add(numbers: String) : Int {

        if (numbers.isEmpty()) return 0

        var numberString = numbers
        var delimiters : Array<String> = arrayOf(",","\n")

        if (numberString.startsWith("//")) {
            delimiters = delimiters.plus(getDelimiters(numberString))
            numberString = numberString.substring(numberString.lastIndexOf('\n') + 1)
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