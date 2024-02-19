package org.example.input

import org.example.math.ExtendedMatrix

class ConsoleInputMatrix : InputMatrix {
    override fun inputMatrix(): ExtendedMatrix {
        InputUtils.printCorrectInputExample()

        val splitLine0 = readln().split(' ')

        var scale = 32
        if (splitLine0.size > 1) {
            scale = splitLine0[1].toInt()
        }

        val dimension = splitLine0[0].toInt()

        val lines = emptyList<String>().toMutableList()

        for (i in 1..dimension) {
            lines.add(readln())
        }

        return InputUtils.makeMatrixFromInput(dimension, scale, lines)
    }
}