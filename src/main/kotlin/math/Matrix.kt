package org.example.math

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

/***
 * Represents a square matrix.
 * Provided basic methods to swap rows and columns.
 * !!! Designed for indexes started from 0.
 *
 * @since 1.0
 * @author Zerumi
 */
class Matrix(private val dim : Int) {

    private val matrixArray: Array<Array<BigDecimal>> =
        Array(dim) {
            Array(dim) {
                BigDecimal(BigInteger("0"), 32)
            }
        }

    fun getDimension() : Int {
        return dim
    }

    fun getMatrixElement(row: Int,
                         col: Int) : BigDecimal {
        return matrixArray[row][col]
    }

    fun setMatrixElement(row : Int,
                         col : Int,
                         element : BigDecimal) {
        matrixArray[row][col] = element
    }

    fun getMatrixRow(row: Int) : Array<BigDecimal> {
        return matrixArray[row]
    }

    fun getMatrixCol(col: Int) : Array<BigDecimal> {
        return Array(dim) {
            matrixArray[it][col]
        }
    }

    fun setMatrixRow(row : Int,
                     vector : Array<BigDecimal>) {
        matrixArray[row] = vector
    }

    fun setMatrixCol(col : Int,
                     vector: Array<BigDecimal>) {
        for (i in 0..<dim) {
            matrixArray[i][col] = vector[i]
        }
    }

    fun swapRows(row1 : Int,
                 row2 : Int) {
        for (i in 0..<dim) {
            val temp = matrixArray[row1][i]
            matrixArray[row1][i] = matrixArray[row2][i]
            matrixArray[row2][i] = temp
        }
    }

    fun swapCols(col1 : Int,
                 col2 : Int) {
        for (i in 0..<dim) {
            val temp = matrixArray[i][col1]
            matrixArray[i][col1] = matrixArray[i][col2]
            matrixArray[i][col2] = temp
        }
    }

    fun mapRow(row : Int,
               mapFunction : (BigDecimal) -> BigDecimal) {
        for (i in 0..<dim) {
            matrixArray[row][i] = mapFunction(matrixArray[row][i])
        }
    }

    fun mapCol(col : Int,
               mapFunction: (BigDecimal) -> BigDecimal) {
        for (i in 0..<dim) {
            matrixArray[i][col] = mapFunction(matrixArray[i][col])
        }
    }

    fun applyVectorToRow(row : Int,
                         vector : Array<BigDecimal>,
                         operation : (BigDecimal, BigDecimal) -> BigDecimal) {

        for (i in 0..<dim) {
            matrixArray[row][i] = operation(matrixArray[row][i], vector[i])
        }
    }

    fun printMatrix() {
        for (i in 0..<dim) {
            for (j in 0..<dim) {
                print("${matrixArray[i][j].setScale(2, RoundingMode.FLOOR).toPlainString()} ")
            }
            println()
        }
    }
}