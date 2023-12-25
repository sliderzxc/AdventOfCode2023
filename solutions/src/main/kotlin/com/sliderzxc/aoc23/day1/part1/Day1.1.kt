package com.sliderzxc.aoc23.day1.part1

import com.sliderzxc.aoc23.utils.lines
import java.io.File

fun main() {
    val result = getSumOfNumberFromStrings(inputTextFile.lines())
    println(result)
}

val inputTextFile = File(
    System.getProperty("user.dir"),
    "solutions/src/main/kotlin/com/sliderzxc/aoc23/day1/part1/input.txt"
)

fun getSumOfNumberFromStrings(lines: List<String>): Int {
    var value = 0
    lines.forEach { line ->
        val firstNumber = line.takeFirstNumber()
        val lastNumber = line.takeLastNumber()
        value += (firstNumber.toString() + lastNumber.toString()).toInt()
    }
    return value
}

fun String.takeFirstNumber(): Int {
    var value = 0
    for (char in this.toList()) {
        if (char.digitToIntOrNull() != null) {
            value = char.digitToInt()
            break
        }
    }
    return value
}

fun String.takeLastNumber(): Int {
    var result = 0
    this.forEach {
        if (it.digitToIntOrNull() != null) {
            result = it.digitToInt()
        }
    }
    return result
}