package org.example.input

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import java.math.BigDecimal

class InputUtils {
    companion object {
        fun makeMatrixFromInput(dimension : Int, scale : Int = 32, input : List<String>) : ExtendedMatrix {
            val resultMatrix = Matrix(dim = dimension, scale = scale)
            val resultExtendedVector = Array<BigDecimal>(dimension) { BigDecimal.ZERO }

            for (i in 0..<dimension) {
                if (input.size == i) throw IllegalArgumentException()

                val splitLine = input[i].split(' ')

                if (splitLine.size != dimension + 1) throw IllegalArgumentException()

                for (j in 0..<dimension) {
                    resultMatrix.setMatrixElement(i,j,splitLine[j])
                }
                resultExtendedVector[i] = BigDecimal(splitLine[dimension])
                    .setScale(resultMatrix.getValueScale())
            }

            val resultExtendedMatrix = ExtendedMatrix(resultMatrix)
            resultExtendedMatrix.setExtendedVector(resultExtendedVector)

            return resultExtendedMatrix
        }
    }
}