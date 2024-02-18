package org.example.input

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import java.io.File
import java.math.BigDecimal

class FileInputMatrix : InputMatrix {
    override fun inputMatrix(): ExtendedMatrix {
        println("Write full path to file below: ")

        val path = readln()
        val file = File(path)

        if (!file.canRead())
            throw IllegalArgumentException()

        val lines = file.useLines { it.toList() }

        val splitLine0 = lines[0].split(' ')

        var scale = 32
        if (splitLine0.size > 1) {
            scale = splitLine0[1].toInt()
        }

        val dimension = splitLine0[0].toInt()

        val resultMatrix = Matrix(dimension, scale)
        val resultExtendedVector = Array<BigDecimal>(dimension) { BigDecimal.ZERO }

        for (i in 1..dimension) {
            if (lines.size == i) throw IllegalArgumentException()

            val splitLine = lines[i].split(' ')

            if (splitLine.size != dimension + 1) throw IllegalArgumentException()

            for (j in 0..<dimension) {
                resultMatrix.setMatrixElement(i - 1,j,splitLine[j])
            }
            resultExtendedVector[i - 1] = BigDecimal(splitLine[dimension])
                .setScale(resultMatrix.getValueScale())
        }

        val resultExtendedMatrix = ExtendedMatrix(resultMatrix)
        resultExtendedMatrix.setExtendedVector(resultExtendedVector)

        return resultExtendedMatrix
    }
}