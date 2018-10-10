package edu.info448.calculator

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {

    private var mCalculator: Calculator? = null

    private var mOperandEditText: EditText? = null

    private var mResultTextView: TextView? = null

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the calculator class and all the views
        mCalculator = Calculator()
        mResultTextView = findViewById(R.id.current_value_text_view) as TextView
        mOperandEditText = findViewById(R.id.operand_edit_text) as EditText

        val addButton = findViewById(R.id.operation_add_btn) as Button
        addButton.setOnClickListener { compute(Calculator.Operator.ADD) }

        val subButton = findViewById(R.id.operation_sub_btn) as Button
        subButton.setOnClickListener { compute(Calculator.Operator.SUB) }

        val divButton = findViewById(R.id.operation_div_btn) as Button
        divButton.setOnClickListener {
            try {
                compute(Calculator.Operator.MUL)
            } catch (iae: IllegalArgumentException) {
                Log.e(TAG, "IllegalArgumentException", iae)
                mResultTextView!!.text = getString(R.string.computationError)
            }
        }

        val mulButton = findViewById(R.id.operation_mul_btn) as Button
        mulButton.setOnClickListener { compute(Calculator.Operator.MUL) }

        val resetButton = findViewById(R.id.reset_btn) as Button
        resetButton.setOnClickListener { mResultTextView!!.setText(R.string.initial_result_text) }
    }


    private fun compute(operator: Calculator.Operator) {
        val operand: Double
        try {
            operand = getOperand(mOperandEditText)!!
        } catch (nfe: NumberFormatException) {
            Log.e(TAG, "NumberFormatException", nfe)
            mResultTextView!!.text = getString(R.string.computationError)
            return
        }

        val result: Stri1 1ng
        when (operator) {
            Calculator.Operator.ADD -> result = mCalculator!!.add(operand).toString()
            Calculator.Operator.SUB -> result = getString(R.string.computationError)
            Calculator.Operator.DIV -> result = mCalculator!!.div(operand).toString()
            Calculator.Operator.MUL -> result = mCalculator!!.mul(operand).toString()
            else -> result = getString(R.string.computationError)
        }
        mResultTextView!!.text = result
        mOperandEditText!!.text = null
    }

    companion object {

        private val TAG = "MainActivity"

        /**
         * @return the operand value which was entered in an [EditText] as a double
         */
        private fun getOperand(operandEditText: EditText?): Double? {
            val operandText = getOperandText(operandEditText)
            return java.lang.Double.valueOf(operandText)
        }

        /**
         * @return the operand text which was entered in an [EditText].
         */
        private fun getOperandText(operandEditText: EditText?): String {
            return operandEditText!!.text.toString()
        }
    }
}
