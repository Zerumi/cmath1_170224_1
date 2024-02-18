package org.example.input

import org.example.math.ExtendedMatrix
import java.io.File

class FileInputMatrix() : InputMatrix {

    private var filepathInitialized = false
    private var filepath = ""
    constructor(filepath : String) : this() {
        this.filepath = filepath
        filepathInitialized = true
    }

    override fun inputMatrix(): ExtendedMatrix {

        if (!filepathInitialized) {
            println("Write full path to file below: ")
            filepath = readln()
        }

        val file = File(filepath)

        if (!file.canRead())
            throw IllegalArgumentException()

        val lines = file.useLines { it.toList() }

        val splitLine0 = lines[0].split(' ')

        var scale = 32
        if (splitLine0.size > 1) {
            scale = splitLine0[1].toInt()
        }

        val dimension = splitLine0[0].toInt()

        return InputUtils.makeMatrixFromInput(dimension, scale, lines.subList(1, lines.size))
    }
}