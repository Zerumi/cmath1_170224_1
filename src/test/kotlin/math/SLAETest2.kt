package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETest2 {

    private lateinit var slae: SLAE

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(3)
        testMatrix.setMatrixElement(0, 0, "10")
        testMatrix.setMatrixElement(0, 1, "-7")
        testMatrix.setMatrixElement(0, 2, "0")
        testMatrix.setMatrixElement(1, 0, "-3")
        testMatrix.setMatrixElement(1, 1, "2.099")
        testMatrix.setMatrixElement(1, 2, "6")
        testMatrix.setMatrixElement(2, 0, "5")
        testMatrix.setMatrixElement(2, 1, "-1")
        testMatrix.setMatrixElement(2, 2, "5")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("7"),
                BigDecimal("3.901"),
                BigDecimal("6"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expectedResult = SLAESolutionStatus.OK

        val expected = arrayOf(
            BigDecimal("0").setScale(32),
            BigDecimal("-1").setScale(32),
            BigDecimal("1").setScale(32),
        )

        assertEquals(expectedResult, slae.solveSLAE().status)
        assertArrayEquals(expected, slae.solveSLAE().solutionVector)
    }
}