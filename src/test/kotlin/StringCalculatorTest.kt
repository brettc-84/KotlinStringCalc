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
            `when`("a newline is used as a delimiter") {
                then("it should return the sum of all the numbers") {
                    assertEquals(calc.Add("1,2,3\n5"), 11)
                }
            }
            `when`("a delimiter is specified as input") {
                then ("it should return the sum of all the numbers") {
                    assertEquals(calc.Add("//;\n1;2"), 3)
                }
            }
            `when`("a negative number is included as input") {
                then("it should throw an exception") {
                    val exception = shouldThrow<NumberFormatException> {
                        calc.Add("1,2,-3")
                    }
                    assertEquals(exception.message, "Negatives not allowed")
                }
            }
            `when`("a number greater than 1000 is passed in") {
                then("it should be ignored") {
                    assertEquals(calc.Add("1,2,1001,3"), 6)
                }
            }
        }
    }
}