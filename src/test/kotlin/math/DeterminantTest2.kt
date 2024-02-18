package math

import org.example.math.Matrix
import org.example.math.MatrixUtils
import org.junit.jupiter.api.Assertions.assertTrue
import java.math.BigDecimal
import kotlin.test.BeforeTest
import kotlin.test.Test

class DeterminantTest2 {

    private val testMatrix = Matrix(5)

    private val epsilon = BigDecimal("0.000000000001")

    @BeforeTest
    fun init() {
        testMatrix.setMatrixElement(0, 0, "-1")
        testMatrix.setMatrixElement(0, 1, "2")
        testMatrix.setMatrixElement(0, 2, "7")
        testMatrix.setMatrixElement(0, 3, "5")
        testMatrix.setMatrixElement(0, 4, "2")
        testMatrix.setMatrixElement(1, 0, "1")
        testMatrix.setMatrixElement(1, 1, "3")
        testMatrix.setMatrixElement(1, 2, "-1")
        testMatrix.setMatrixElement(1, 3, "2")
        testMatrix.setMatrixElement(1, 4, "-1")
        testMatrix.setMatrixElement(2, 0, "2")
        testMatrix.setMatrixElement(2, 1, "1")
        testMatrix.setMatrixElement(2, 2, "2")
        testMatrix.setMatrixElement(2, 3, "3")
        testMatrix.setMatrixElement(2, 4, "4")
        testMatrix.setMatrixElement(3, 0, "-5")
        testMatrix.setMatrixElement(3, 1, "2")
        testMatrix.setMatrixElement(3, 2, "-1")
        testMatrix.setMatrixElement(3, 3, "0")
        testMatrix.setMatrixElement(3, 4, "0")
        testMatrix.setMatrixElement(4, 0, "3")
        testMatrix.setMatrixElement(4, 1, "3")
        testMatrix.setMatrixElement(4, 2, "1")
        testMatrix.setMatrixElement(4, 3, "0")
        testMatrix.setMatrixElement(4, 4, "0")
    }

    @Test
    fun determinant() {
        val expected = BigDecimal("-1806").setScale(32)

        assertTrue(expected - MatrixUtils.matrixDeterminant(testMatrix) <= epsilon)
    }
}