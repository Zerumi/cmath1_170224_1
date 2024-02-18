package math

import org.example.math.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETestSwap1 {

    private lateinit var slae: SLAE

    private val epsilon = BigDecimal("0.000000000001")

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(3)

        testMatrix.setMatrixElement(0, 0, "2")
        testMatrix.setMatrixElement(0, 1, "3")
        testMatrix.setMatrixElement(0, 2, "-1")
        testMatrix.setMatrixElement(1, 0, "1")
        testMatrix.setMatrixElement(1, 1, "0")
        testMatrix.setMatrixElement(1, 2, "2")
        testMatrix.setMatrixElement(2, 0, "1")
        testMatrix.setMatrixElement(2, 1, "-2")
        testMatrix.setMatrixElement(2, 2, "1")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("9"),
                BigDecimal("2"),
                BigDecimal("3"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expected = arrayOf(
            BigDecimal("4").setScale(32),
            BigDecimal("0").setScale(32),
            BigDecimal("-1").setScale(32),
        )

        val expectedResult = SLAESolutionStatus.OK
        assertEquals(expectedResult, slae.solveSLAE().status)

        val checker = SLAESolutionChecker(slae.solveSLAE())
        assertTrue(checker.calculateResidualVector().all { it <= epsilon })

        assertArrayEquals(expected, slae.solveSLAE().solutionVector)
    }
}