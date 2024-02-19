package org.example.input

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import java.math.BigDecimal

class InputUtils {
    companion object {
        fun makeMatrixFromInput(dimension: Int, scale: Int = 32, input: List<String>): ExtendedMatrix {
            val resultMatrix = Matrix(dim = dimension, scale = scale)
            val resultExtendedVector = Array<BigDecimal>(dimension) { BigDecimal.ZERO }

            for (i in 0..<dimension) {
                if (input.size == i) break

                val splitLine = input[i].split(' ')

                if (splitLine.size != dimension + 1) throw IllegalArgumentException()

                for (j in 0..<dimension) {
                    resultMatrix.setMatrixElement(i, j, splitLine[j])
                }
                resultExtendedVector[i] = BigDecimal(splitLine[dimension]).setScale(resultMatrix.getValueScale())
            }

            val resultExtendedMatrix = ExtendedMatrix(resultMatrix)
            resultExtendedMatrix.setExtendedVector(resultExtendedVector)

            return resultExtendedMatrix
        }

        fun printCorrectInputExample() {
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
        }
    }
}