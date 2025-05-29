package coding_test

import kotlin.math.max

class DayThree {

    fun test03(my_string: String, k: Int): String {
        var answer: String = ""
        repeat(k) {
            answer += my_string
        }
        return answer
    }

    fun test04(a: Int, b: Int): Int {
        val answer: Int = if ((a.toString() + b.toString()).toInt() > (b.toString() + a.toString()).toInt()) {
            (a.toString() + b.toString()).toInt()
        } else {
            (b.toString() + a.toString()).toInt()
        }
        return answer
    }

    fun test05(a: Int, b: Int): Int {
        return max((a.toString() + b.toString()).toInt(), 2 * a * b)
    }
}

fun main() {
    val test03 = DayThree().test03("string", 3)
    println("test03 : $test03")

    val test04 = DayThree().test04(9, 91)
    println("test04 : $test04")

    val test05 = DayThree().test05(2, 91)
    println("test05 : $test05")
}