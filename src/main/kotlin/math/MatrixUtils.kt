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
                        .divide(matrix.getMatrixElement(i, i), RoundingMode.HALF_UP).negate()

                    val modifiedVector = firstVector.map {
                        it.multiply(removingCoefficient)
                    }.toTypedArray()

                    matrix.applyVectorToRow(j, modifiedVector, BigDecimal::plus)
                }
            }
        }

        fun bringMatrixToValidForm(matrix: Matrix) : Boolean {
            for (i in 0..<matrix.getDimension()) {
                if (matrix.getMatrixElement(i, i) != BigDecimal.ZERO.setScale(matrix.getValueScale())) {
                    var swappedSuccess = false
                    for (j in 0..<matrix.getDimension()) {
                        if (matrix.getMatrixElement(i, j) != BigDecimal.ZERO.setScale(matrix.getValueScale())) {
                            if (matrix.getMatrixElement(j, i) != BigDecimal.ZERO.setScale(matrix.getValueScale())) {
                                matrix.swapCols(i, j)
                                swappedSuccess = true
                                break
                            }
                        }
                    }
                    if (!swappedSuccess) return false
                }
            }
            return true
        }

        fun matrixDeterminant(matrix: Matrix): BigDecimal {
            val matrixClone = Matrix(matrix)
            if (!bringMatrixToValidForm(matrixClone))
                return BigDecimal.ZERO.setScale(matrix.getValueScale())
            diagMatrix(matrixClone)
            var result = BigDecimal("1").setScale(matrix.getValueScale())
            for (i in 0..<matrixClone.getDimension()) {
                result = result.multiply(matrixClone.getMatrixElement(i, i))
                    .setScale(matrixClone.getValueScale(), RoundingMode.HALF_UP)
            }
            if (matrixClone.getSwapCount() % 2 != 0) result = result.negate()
            return result
        }
    }
}