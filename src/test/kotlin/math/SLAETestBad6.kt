package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETestBad6 {

    private lateinit var slae: SLAE

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(5)
        testMatrix.setMatrixElement(0, 0, "1")
        testMatrix.setMatrixElement(0, 1, "-2")
        testMatrix.setMatrixElement(0, 2, "1")
        testMatrix.setMatrixElement(0, 3, "-2")
        testMatrix.setMatrixElement(0, 4, "1")
        testMatrix.setMatrixElement(1, 0, "2")
        testMatrix.setMatrixElement(1, 1, "-4")
        testMatrix.setMatrixElement(1, 2, "-1")
        testMatrix.setMatrixElement(1, 3, "1")
        testMatrix.setMatrixElement(1, 4, "0")
        testMatrix.setMatrixElement(2, 0, "2")
        testMatrix.setMatrixElement(2, 1, "-2")
        testMatrix.setMatrixElement(2, 2, "2")
        testMatrix.setMatrixElement(2, 3, "-2")
        testMatrix.setMatrixElement(2, 4, "1")
        testMatrix.setMatrixElement(3, 0, "1")
        testMatrix.setMatrixElement(3, 1, "0")
        testMatrix.setMatrixElement(3, 2, "1")
        testMatrix.setMatrixElement(3, 3, "0")
        testMatrix.setMatrixElement(3, 4, "0")
        testMatrix.setMatrixElement(4, 0, "4")
        testMatrix.setMatrixElement(4, 1, "-6")
        testMatrix.setMatrixElement(4, 2, "4")
        testMatrix.setMatrixElement(4, 3, "-6")
        testMatrix.setMatrixElement(4, 4, "3")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("0"),
                BigDecimal("-9"),
                BigDecimal("4"),
                BigDecimal("4"),
                BigDecimal("4"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expectedResult = SLAESolutionStatus.INFINITE_SOLUTIONS

        assertEquals(expectedResult, slae.solveSLAE().status)
    }
}