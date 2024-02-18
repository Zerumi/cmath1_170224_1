@file:JvmName("Main")

package org.example

import org.example.input.ConsoleInputMatrix
import org.example.input.FileInputMatrix
import org.example.input.InputMatrix
import org.example.math.*

fun main(args: Array<String>) {

    val inputMatrix: InputMatrix

    if (args.isNotEmpty()) {
        inputMatrix = FileInputMatrix(args[0])
    } else {

        println("Welcome to SLAE solver program")
        println("Select input format: file/console (console by default)")
        print(">[f/c]: ")

        val fileAnswer = readln()

        inputMatrix = when (fileAnswer) {
            "f", "file" -> FileInputMatrix()
            "c", "console" -> ConsoleInputMatrix()
            else -> ConsoleInputMatrix()
        }
    }

    val matrixToSolve = inputMatrix.inputMatrix()

    println("SLAE Matrix:")
    matrixToSolve.printMatrix()

    println("Triangle Matrix:")
    val triangleMatrix = ExtendedMatrix(matrixToSolve)
    MatrixUtils.triangleMatrix(triangleMatrix)
    triangleMatrix.printMatrix()

    val slae = SLAE(matrixToSolve)
    val solution = slae.solveSLAE()

    println(
        when (solution.status) {
            SLAESolutionStatus.OK -> "Found a solution"
            SLAESolutionStatus.INVALID_MATRIX -> "SLAE matrix was invalid or SLAE has uncountable amount of solutions"
            SLAESolutionStatus.INFINITE_SOLUTIONS -> "SLAE has uncountable amount of solutions"
            SLAESolutionStatus.INCOMPATIBLE -> "SLAE has no solutions"
        }
    )

    if (solution.status == SLAESolutionStatus.OK) {
        val checker = SLAESolutionChecker(solution)
        val errorArray = checker.calculateResidualVector()
        println("Solution | Residual Error: ")
        for (i in solution.solutionVector.indices) {
            println("x${i + 1}: ${solution.solutionVector[i].toPlainString()} | ${errorArray[i].toPlainString()}")
        }
    }
}
