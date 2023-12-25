package com.sliderzxc.aoc23.day1.part1

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
        val first = line.firstNotNullOf(Char::digitToIntOrNull)
        val second = line.lastNotNullOf(Char::digitToIntOrNull)
        ("$first$second").toInt()
    }
    println(sum)
}

private inline fun <T> String.lastNotNullOf(block: (Char) -> T?): T {
    return reversed().firstNotNullOf(block)
}