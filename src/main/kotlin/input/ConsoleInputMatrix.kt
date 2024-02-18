package org.example.input

import org.example.math.ExtendedMatrix

class ConsoleInputMatrix : InputMatrix {
    override fun inputMatrix(): ExtendedMatrix {
        println("Enter matrix in this format: ")
        println("dimension [scale / 32 is default]")
        println("(0,0) (0,1) (0,2) ... (0, dimension) (coefficient0)")
        println("(1,0) (1,1) (1,2) ... (1, dimension) (coefficient1)")
        println("...")
        println("(k,0) (k,1) (k,2) ... (k, dimension) (coefficientK)")
        println("...")
        println("(dimension,0) (dimension,1) (dimension,2) ... (dimension, dimension) (coefficientDimension)")
        println()
        println("Example of correct input: ")
        println("3 32")
        println("10 -7 0 7")
        println("-3 2 6 4")
        println("5 -1 5 6")
        println()
        println("(Solution for this matrix: {0, -1, 1}")

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