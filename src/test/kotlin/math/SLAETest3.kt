package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETest3 {

    private lateinit var slae: SLAE

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(2)
        testMatrix.setMatrixElement(0, 0, "3")
        testMatrix.setMatrixElement(0, 1, "-2")
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

        val expectedResult = SLAESolutionStatus.OK

        val expected = arrayOf(
            BigDecimal("0").setScale(32),
            BigDecimal("3").setScale(32),
        )

        assertEquals(expectedResult, slae.solveSLAE().status)
        assertArrayEquals(expected, slae.solveSLAE().solutionVector)
    }
}