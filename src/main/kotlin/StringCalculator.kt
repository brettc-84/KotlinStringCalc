/**
 * Created by brettcoomer on 2017/01/22.
 */
class StringCalculator {

    fun Add(numbers: String) :Int {
        var total: Int =0
        if (!numbers.isEmpty()) {
            val list = numbers.split(',')
            for (n in list) {
                total += n.toInt()
            }
        }
        return total
    }
}