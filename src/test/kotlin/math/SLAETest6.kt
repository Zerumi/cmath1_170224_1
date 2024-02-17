package math

import org.example.math.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETest6 {

    private lateinit var slae: SLAE

    private val epsilon = BigDecimal("0.000000000001")

    @BeforeTest
    fun init() {
        val testMatrix = Matrix(2)

        testMatrix.setMatrixElement(0, 0, "5")
        testMatrix.setMatrixElement(0, 1, "2")
        testMatrix.setMatrixElement(1, 0, "2")
        testMatrix.setMatrixElement(1, 1, "1")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("7"),
                BigDecimal("9"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expectedResult = SLAESolutionStatus.OK
        assertEquals(expectedResult, slae.solveSLAE().status)

        val checker = SLAESolutionChecker(slae.solveSLAE())
        assertTrue(checker.calculateResidualVector().all { it <= epsilon })
    }
}