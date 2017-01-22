import io.kotlintest.specs.BehaviorSpec
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by brettcoomer on 2017/01/22.
 */
class MyTests : BehaviorSpec() {
    init {
        given("a calculator") {
            val calc = StringCalculator()
            `when`("a blank string is passed in") {
                then("it should return zero") {
                    assertEquals(calc.Add(""), 0)
                }
            }
            `when`("a single number is passed in") {
                then("it should return that number") {
                    assertEquals(calc.Add("12"), 12)
                }
            }
            `when`("a list of two numbers is passed in") {
                then("it should return the sum of the two numbers") {
                    assertEquals(calc.Add("1,2"), 3)
                }
            }
            `when`("a long list of numbers is passed in") {
                then("it should return the sum of all the numbers") {
                    assertEquals(calc.Add("1,2,3,4"), 10)
                }
            }
            `when`("a newline is used as a delimeter") {
                then("it should return the sum of all the numbers") {
                    assertEquals(calc.Add("1,2,3\n5"), 11)
                }
            }
        }
    }
}