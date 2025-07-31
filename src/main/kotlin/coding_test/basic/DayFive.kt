package coding_test.basic

import coding_test.DayFour

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
            if (included[i]) result += a + (i*d)
        }

        return result
    }
}

fun main() {

    println("test01 : ${DayFive().test01("abc1abc1abc")}")

}