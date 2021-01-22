import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'gradingStudents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY grades as parameter.
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    val roundedGrade = mutableListOf<Int>()
    for (i in grades.indices){
        roundedGrade.add( roundedGrade(grades[i]))
    }
    return roundedGrade.toTypedArray()
}

fun nextMultipleof5(number:Int):Int{
    return (5 -number%5) +number
}

fun differenceBetweenGradleAndNextMultiple(grade:Int): Int {
    return nextMultipleof5(grade)-grade
}

fun roundedGrade(grade: Int): Int {
    return if (grade < 38){
        grade
    }else{
        val  diff =differenceBetweenGradleAndNextMultiple(grade)
        when{
            diff <3 ->{
                nextMultipleof5(grade)
            }
            else -> grade

        }
    }

}
fun main(args: Array<String>) {
    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
