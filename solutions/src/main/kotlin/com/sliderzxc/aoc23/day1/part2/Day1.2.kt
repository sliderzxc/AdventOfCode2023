package com.sliderzxc.aoc23.day1.part2

import com.sliderzxc.aoc23.utils.BASE_PROJECT_DIR
import com.sliderzxc.aoc23.utils.lines
import java.io.File

val inputTextFile = File(
    System.getProperty("user.dir"),
    "$BASE_PROJECT_DIR/day1/input.txt"
)

fun main() {
    val lines = inputTextFile.lines()
    val sum = lines.sumOf { line ->
        val first = line.indices.firstNotNullOf { index -> line.extractDigitOrNull(index) }
        val second = line.indices.lastNotNullOf { index -> line.extractDigitOrNull(index) }
        ("$first$second").toInt()
    }
    println(sum)
}

private fun String.extractDigitOrNull(index: Int): Int? {
    val simple = this[index].digitToIntOrNull()
    if (simple != null) return simple

    return digits.indexOfFirstOrNull { digit ->
        this.startsWith(digit, index)
    }?.plus(other = 1)
}

private val digits = listOf(
    "one", "two", "three",
    "four", "five", "six",
    "seven", "eight", "nine"
)

private inline fun <T> List<T>.indexOfFirstOrNull(
    block: (T) -> Boolean
): Int? = indexOfFirst(block).takeIf { it != -1 }

private inline fun <T, R> Iterable<T>.lastNotNullOf(block: (T) -> R?): R {
    return reversed().firstNotNullOf(block)
}