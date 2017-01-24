/**
 * Created by brettcoomer on 2017/01/22.
 */
class StringCalculator {



    fun sanitiseString(input: String) : String {
        var newString = input
        if (input.startsWith("//")) {
            var delimiter = newString.substring(2,3)
            val ind = input.indexOf('\n') + 1
            newString = input.substring(ind).replace(delimiter,",")
        }
        return newString.replace("\\n".toRegex(),",")
    }

    fun Add(numbers: String) :Int {
        var total: Int =0
        if (!numbers.isEmpty()) {
            var niceNumbers = sanitiseString(numbers)
            val list = niceNumbers.split(',')
            for (n in list) {
                if (n.toInt() < 0) {
                    throw NumberFormatException("Negatives not allowed")
                }
                if (n.toInt() <= 1000) {
                    total += n.toInt()
                }
            }
        }
        return total
    }
}