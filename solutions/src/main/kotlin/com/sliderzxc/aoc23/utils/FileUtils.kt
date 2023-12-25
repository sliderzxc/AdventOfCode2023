package com.sliderzxc.aoc23.utils

import java.io.File

fun File.lines(): List<String> {
    return this.readLines()
}

const val BASE_PROJECT_DIR = "solutions/src/main/kotlin/com/sliderzxc/aoc23"