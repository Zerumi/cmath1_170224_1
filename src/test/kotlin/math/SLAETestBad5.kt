package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETestBad5 {

    private lateinit var slae: SLAE

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(4)
        testMatrix.setMatrixElement(0, 0, "1")
        testMatrix.setMatrixElement(0, 1, "2")
        testMatrix.setMatrixElement(0, 2, "3")
        testMatrix.setMatrixElement(0, 3, "4")
        testMatrix.setMatrixElement(1, 0, "1")
        testMatrix.setMatrixElement(1, 1, "2")
        testMatrix.setMatrixElement(1, 2, "3")
        testMatrix.setMatrixElement(1, 3, "4")
        testMatrix.setMatrixElement(2, 0, "1")
        testMatrix.setMatrixElement(2, 1, "2")
        testMatrix.setMatrixElement(2, 2, "3")
        testMatrix.setMatrixElement(2, 3, "4")
        testMatrix.setMatrixElement(3, 0, "1")
        testMatrix.setMatrixElement(3, 1, "2")
        testMatrix.setMatrixElement(3, 2, "3")
        testMatrix.setMatrixElement(3, 3, "4")
        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("1"),
                BigDecimal("2"),
                BigDecimal("3"),
                BigDecimal("4"),
            )
        )
        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expectedResult = SLAESolutionStatus.INCOMPATIBLE

        assertEquals(expectedResult, slae.solveSLAE().status)
    }
}