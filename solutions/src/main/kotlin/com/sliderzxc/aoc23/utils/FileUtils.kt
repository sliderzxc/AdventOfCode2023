package com.sliderzxc.aoc23.utils

import java.io.File

fun File.lines(): List<String> {
    return this.readLines()
}