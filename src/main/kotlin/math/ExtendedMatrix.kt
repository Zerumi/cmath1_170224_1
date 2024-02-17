package org.example.math

import java.math.BigDecimal
import java.math.RoundingMode

class ExtendedMatrix
    (matrix: Matrix,
     solutionVector : Array<BigDecimal>) : Matrix(matrix) {
    private fun extendMatrix(array: Array<BigDecimal>) {
        this.addMatrixCol(array)
    }

    init {
        for (i in 0..<matrix.getDimension())
            solutionVector[i].setScale(matrix.getValueScale())
        extendMatrix(solutionVector)
    }

    override fun applyVectorToRow(
        row: Int,
        vector: Array<BigDecimal>,
        operation: (BigDecimal, BigDecimal) -> BigDecimal
    ) {
        setMatrixElement(row, this.getDimension(),
            operation(this.getMatrixElement(row, this.getDimension()), vector[this.getDimension()]))
        super.applyVectorToRow(row, vector, operation)
    }

    override fun printMatrix() {
        for (i in 0..<this.getDimension()) {
            for (j in 0..this.getDimension()) {
                print("${this.getMatrixElement(i,j).setScale(2, RoundingMode.FLOOR).toPlainString()} ")
            }
            println()
        }
    }
}