package coding_test.basic

import coding_test.DayFour
import kotlin.math.pow

class DayFive {

    fun test01(code: String): String {
        var mode = 0;
        var result = ""
        for (i in code.indices) {
            val codeChar = code[i]
            if (codeChar == '1')
                if (mode == 0) mode = 1 else mode = 0
            else {
                if (mode == 1 && i % 2 != 0) {
                    result += codeChar.toString()
                }
                if (mode == 0 && i % 2 != 1) {
                    result += codeChar.toString()
                }
            }
        }
        return result.ifEmpty { "EMPTY" }
    }

    fun test02(a: Int, d: Int, included: BooleanArray): Int {
        var result = 0
        for (i in 0..included.size - 1) {
            if (included[i]) result += a + (i * d)
        }

        return result
    }


    fun test03(a: Int, b: Int, c: Int): Int {
        fun Int.pow(number: Int): Int {
            return this.toDouble().pow(number).toInt()
        }

        val result = a + b + c
        return if (a != b && b != c && a != c) {
            result
        } else if (a == c && a == b) {
            result * (a.pow(2) + b.pow(2) + c.pow(2)) * (a.pow(3) + b.pow(3) + c.pow(3))
        } else {
            result * (a.pow(2) + b.pow(2) + c.pow(2))
        }
    }

    fun test04(num_list: IntArray): Int {
        var multipliedResult = 1
        var sumResult = 0
        for (it in num_list) {
            multipliedResult = it * multipliedResult
            sumResult = it + sumResult
        }

        return if (multipliedResult > sumResult * sumResult) 0 else 1
    }

    fun test05(num_list: IntArray): Int {
        var evenString = ""
        var oddString = ""
        num_list.forEach { it ->
            if (it % 2 == 0) evenString += it.toString() else oddString += it
        }
        return evenString.toInt() + oddString.toInt()
    }
}

fun main() {

    println("test01 : ${DayFive().test01("abc1abc1abc")}")
    println("test03 : ${DayFive().test03(5, 3, 3)}")
    println("test04 : ${DayFive().test04(intArrayOf(3, 4, 5, 2, 1))}")
    println("test05 : ${DayFive().test05(intArrayOf(3, 4, 5, 2, 1))}")

}