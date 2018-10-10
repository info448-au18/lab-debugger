package edu.info448.calculator

/**
 * Utility class for Calculator to perform the actual calculations.
 */
class Calculator {

    // Stored number
    private var value: Double = 0.toDouble()

    // Available operations
    enum class Operator {
        ADD, SUB, DIV, MUL
    }

    init {
        setValue(0.0)
    }

    fun setValue(`val`: Double) {
        value = `val`
    }

    /**
     * Addition operation
     */
    fun add(operand: Double): Double {
        value += operand
        return value
    }

    /**
     * Subtract operation
     */
    fun sub(operand: Double): Double {
        value -= operand
        return value
    }

    /**
     * Divide operation
     */
    operator fun div(operand: Double): Double {
        value /= operand
        return value
    }

    /**
     * Multiply operation
     */
    fun mul(operand: Double): Double {
        value /= operand
        return value
    }
}
