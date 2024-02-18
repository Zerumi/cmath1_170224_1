package math

import org.example.math.ExtendedMatrix
import org.example.math.Matrix
import org.example.math.SLAE
import org.example.math.SLAESolutionStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.BeforeTest

class SLAETestBad4 {

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
        testMatrix.setMatrixElement(3, 0, "0")
        testMatrix.setMatrixElement(3, 1, "0")
        testMatrix.setMatrixElement(3, 2, "0")
        testMatrix.setMatrixElement(3, 3, "0")

        val testExtendedMatrix = ExtendedMatrix(testMatrix)
        testExtendedMatrix.setExtendedVector(
            arrayOf(
                BigDecimal("0"),
                BigDecimal("0"),
                BigDecimal("0"),
                BigDecimal("0"),
            )
        )

        slae = SLAE(testExtendedMatrix)
    }

    @Test
    fun solveSLAE() {

        val expectedResult = SLAESolutionStatus.INVALID_MATRIX

        assertEquals(expectedResult, slae.solveSLAE().status)
    }
}