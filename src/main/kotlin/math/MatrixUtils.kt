package org.example.math

import java.math.BigDecimal
import java.math.RoundingMode

class MatrixUtils {
    companion object {
        fun diagMatrix(matrix: Matrix) {
            assert(matrix.getMatrixElement(0, 0) != BigDecimal("0").setScale(matrix.getValueScale()))

            for (i in 0..<matrix.getDimension()) {
                for (j in i + 1..<matrix.getDimension()) {
                    val firstVector = matrix.getMatrixRow(i)

                    val removingCoefficient = matrix.getMatrixElement(j, i)
                        .divide(matrix.getMatrixElement(i, i), RoundingMode.FLOOR).negate()

                    val modifiedVector = firstVector.map {
                        it.multiply(removingCoefficient)
                    }.toTypedArray()

                    matrix.applyVectorToRow(j, modifiedVector, BigDecimal::plus)
                }
            }
        }
    }
}