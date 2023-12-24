package com.sliderzxc.adventofcode2023

fun main() {
    // read input
    val input = generateSequence { readlnOrNull() }.joinToString("\n")
    val lines = input.lines()
    print(getSumOfNumberFromStrings(lines))
}

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