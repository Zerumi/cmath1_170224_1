@file:JvmName("Main")

package org.example

import org.example.input.ConsoleInputMatrix
import org.example.input.FileInputMatrix
import org.example.input.InputMatrix
import org.example.math.*

fun main(args : Array<String>) {

    val inputMatrix : InputMatrix

    if (args.isNotEmpty()) {
        inputMatrix = FileInputMatrix(args[0])
    }
    else {

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

    println(when(solution.status) {
        SLAESolutionStatus.OK -> "Found a solution"
        SLAESolutionStatus.INVALID_MATRIX -> "SLAE matrix was invalid or SLAE has uncountable amount of solutions"
        SLAESolutionStatus.INFINITE_SOLUTIONS -> "SLAE has uncountable amount of solutions"
        SLAESolutionStatus.INCOMPATIBLE -> "SLAE has no solutions"
    })

    if (solution.status == SLAESolutionStatus.OK) {
        println("Solution: {${solution.solutionVector.contentToString()}}")
        println()
        val checker = SLAESolutionChecker(solution)
        println("Error: {${checker.calculateResidualVector().contentToString()}}")
    }


    /*
    println("")

    // get matrix
    print("Enter matrix dimension: ")
    val dimension = readln().toInt()

    val matrix = Matrix(dimension)

    println("Created Matrix:")
    matrix.printMatrix()

    println("Fill elements of the matrix:")
    for (i in 0..<dimension) {
        for (j in 0..<dimension) {
            matrix.setMatrixElement(i, j, readln())
        }
    }

    println("Filled matrix:")
    matrix.printMatrix()

    println("Extend matrix. Fill elements: ")
    val solutions = Array<BigDecimal>(dimension) { BigDecimal(readln()).setScale(32) }

    println("Extend matrix: ")
    val extendedMatrix = ExtendedMatrix(matrix)
    extendedMatrix.setExtendedVector(solutions)

    println("Validate matrix: ")
    MatrixUtils.bringMatrixToValidForm(extendedMatrix)
    extendedMatrix.printMatrix()

    println("Diagonalize it:")
    MatrixUtils.diagMatrix(extendedMatrix)
    extendedMatrix.printMatrix()


    println("Creating SLAE...")
    val slae = SLAE(extendedMatrix)
    println("Solution:")
    val slaeSolution = slae.solveSLAE()
    slaeSolution.solutionVector.forEach { println(it.toPlainString()) }

    println("Calculate resuidual: ")
    val checker = SLAESolutionChecker(slaeSolution)
    checker.calculateResidualVector().forEach { println(it.toPlainString()) }
     */
}
