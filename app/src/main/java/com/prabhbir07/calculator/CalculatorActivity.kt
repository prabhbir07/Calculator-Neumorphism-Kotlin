package com.prabhbir07.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)


        /*Number Buttons*/

        btn1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btn2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btn4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btn0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        plusBtn.setOnClickListener {
            if (tvWorking.text.isEmpty()) {
                evaluateExpression("0+", clear = true)
            } else {
                val i: String = tvWorking.text.last().toString()
                val value = tvWorking.text.toString()
                if (i == "-" || i == "*" || i == "/") {

                    val changeLast = value.dropLast(1) + "+"
                    tvWorking.text = changeLast

                } else {
                    if (i != "+") {
                        evaluateExpression("+", clear = true)
                    }
                }
            }


        }

        minusBtn.setOnClickListener {
            if (tvWorking.text.isEmpty()) {
                evaluateExpression("0-", clear = true)
            } else {
                val i: String = tvWorking.text.last().toString()
                val value = tvWorking.text.toString()
                if (i == "+" || i == "*" || i == "/") {

                    val changeLast = value.dropLast(1) + "-"
                    tvWorking.text = changeLast

                } else {
                    if (i != "-") {
                        evaluateExpression("-", clear = true)
                    }
                }
            }

        }

        multiplyBtn.setOnClickListener {
            if (tvWorking.text.isEmpty()) {
                evaluateExpression("0*", clear = true)
            } else {
                val i: String = tvWorking.text.last().toString()
                val value = tvWorking.text.toString()
                if (i == "-" || i == "+" || i == "/") {

                    val changeLast = value.dropLast(1) + "*"
                    tvWorking.text = changeLast

                } else {
                    if (i != "*") {
                        evaluateExpression("*", clear = true)
                    }
                }
            }
        }

        dividebtn.setOnClickListener {
            if (tvWorking.text.isEmpty()) {
                evaluateExpression("0/", clear = true)
            } else {
                val i: String = tvWorking.text.last().toString()
                val value = tvWorking.text.toString()
                if (i == "-" || i == "*" || i == "+") {

                    val changeLast = value.dropLast(1) + "/"
                    tvWorking.text = changeLast

                } else {
                    if (i != "/") {
                        evaluateExpression("/", clear = true)
                    }
                }
            }
        }

        btnDot.setOnClickListener {

            if (tvWorking.text.isEmpty()) {
                evaluateExpression("0.", clear = true)
            } else {
                val i: String = tvWorking.text.last().toString()
                if (i != ".") {
                    evaluateExpression(".", clear = true)

                }
            }
        }

        btnAllClear.setOnClickListener {
            tvWorking.text = ""
            tvResult.text = ""
        }

        btnEqual.setOnClickListener {
            try {


                if (tvWorking.text.isNotEmpty()) {
                    val text = tvWorking.text.toString()
                    val expression = ExpressionBuilder(text).build()

                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        tvResult.text = longResult.toString()
                    } else {
                        tvResult.text = result.toString()
                    }

                } else {
                    Toast.makeText(this, "Please enter some value", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                tvResult.text = "Error"
            }

        }

        imgBtnBackspace.setOnClickListener {
            val text = tvWorking.text.toString()
            if (text.isNotEmpty()) {
                tvWorking.text = text.dropLast(1)
            }

            tvResult.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/


    private fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            tvResult.text = ""

            tvWorking.append(string)
        } else {
            tvWorking.append(tvResult.text)
            tvWorking.append(string)
            tvResult.text = ""
        }
    }


}



