package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETestBad1 {

    private lateinit var slae: SLAE

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(2)
        testMatrix.setMatrixElement(0, 0, "5")
        testMatrix.setMatrixElement(0, 1, "1")
        testMatrix.setMatrixElement(1, 0, "5")
        testMatrix.setMatrixElement(1, 1, "1")
        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("-6"),
                BigDecimal("3"),
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