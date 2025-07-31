package coding_test

class DayFour {

    fun test01(num: Int, n: Int): Int {
        return if (num % n == 0) return 1 else 0
    }

    fun test02(number: Int, n: Int, m: Int): Int {
        return if (number % n == 0 && number % m == 0) return 1 else 0
    }

    fun test03(n: Int): Int {
        var answer: Int = 0
        val isOddNumber = (n % 2 != 0)
        for (i in n downTo (if (isOddNumber) 1 else 2) step 2) {
            if (isOddNumber) {
                answer += i
            } else {
                answer += (i * i)
            }
        }
        return answer
    }

    fun test04(ineq: String, eq: String, n: Int, m: Int): Int {
        if (ineq == ">") {
            if (eq == "=") {
                return if (n >= m) 1 else 0;
            } else {
                return if (n > m) 1 else 0;
            }
        } else {
            if (eq == "=") {
                return if (n <= m) 1 else 0;
            } else {
                return if (n < m) 1 else 0;
            }
        }
    }

    /*

    test 04

    class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer: Int = 0
        val op = ineq + eq

        when (op) {
            "<=" -> answer = if (n <= m) 1 else 0
            ">=" -> answer = if (n >= m) 1 else 0
            "<!" -> answer = if (n < m) 1 else 0
            ">!" -> answer = if (n > m) 1 else 0
        }

        return answer
        }
    }
    *
    */

    fun test05(a: Int, b: Int, flag: Boolean): Int {
        return if(flag) a + b else a - b
    }



}

fun main() {
    println("test01 : ${DayFour().test01(9, 3)}")
    println("test02 : ${DayFour().test02(60, 2, 3)}")
    println("test03 : ${DayFour().test03(10)}")
}