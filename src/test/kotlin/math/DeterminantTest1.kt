package math

import org.example.math.Matrix
import org.example.math.MatrixUtils
import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import kotlin.test.BeforeTest
import kotlin.test.Test

class DeterminantTest1 {

    private val testMatrix = Matrix(5)

    @BeforeTest
    fun init() {
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
    }

    @Test
    fun determinant() {
        val expected = BigDecimal.ZERO.setScale(32)

        assertEquals(expected, MatrixUtils.matrixDeterminant(testMatrix))
    }
}