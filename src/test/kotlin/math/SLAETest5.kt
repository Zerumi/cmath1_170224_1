package math

import org.example.math.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETest5 {

    private lateinit var slae: SLAE

    private val epsilon = BigDecimal("0.000000000001")

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(3)

        testMatrix.setMatrixElement(0, 0, "2")
        testMatrix.setMatrixElement(0, 1, "1")
        testMatrix.setMatrixElement(0, 2, "1")
        testMatrix.setMatrixElement(1, 0, "1")
        testMatrix.setMatrixElement(1, 1, "-1")
        testMatrix.setMatrixElement(1, 2, "0")
        testMatrix.setMatrixElement(2, 0, "3")
        testMatrix.setMatrixElement(2, 1, "-1")
        testMatrix.setMatrixElement(2, 2, "2")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("2"),
                BigDecimal("-2"),
                BigDecimal("2"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        /* expected
        arrayOf(
            BigDecimal("-1").setScale(32),
            BigDecimal("1").setScale(32),
            BigDecimal("3").setScale(32),
        ) */

        val expectedResult = SLAESolutionStatus.OK
        assertEquals(expectedResult, slae.solveSLAE().status)

        val checker = SLAESolutionChecker(slae.solveSLAE())
        assertTrue(checker.calculateResidualVector().all { it <= epsilon })
    }
}