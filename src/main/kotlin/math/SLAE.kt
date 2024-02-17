package org.example.math

import java.math.BigDecimal
import java.math.RoundingMode

class SLAE(
    sourceMatrix: ExtendedMatrix
) {
    private val matrix = ExtendedMatrix(sourceMatrix)
    fun solveSLAE(): SLAESolution {

        if (!MatrixUtils.bringMatrixToValidForm(matrix))
            return SLAESolution.invalidMatrix()

        MatrixUtils.diagMatrix(matrix)
        return SLAESolution.ok(solveForDiagMatrix())
    }

    private fun solveForDiagMatrix(): Array<BigDecimal> {

        val solution = Array(matrix.getDimension()) {
            BigDecimal("0").setScale(matrix.getValueScale())
        }

        for (i in matrix.getDimension() - 1 downTo 0) {
            var sum = BigDecimal("0").setScale(matrix.getValueScale())
            for (j in i + 1..<matrix.getDimension()) {
                sum = sum.add(
                    matrix.getMatrixElement(i, j).multiply(solution[j])
                        .setScale(matrix.getValueScale(), RoundingMode.FLOOR)
                )
            }

            solution[i] = matrix.getMatrixElement(i, matrix.getDimension()).subtract(sum)
                .divide(matrix.getMatrixElement(i, i), RoundingMode.FLOOR)
        }

        return solution
    }
}