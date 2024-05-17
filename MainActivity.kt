package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var etA: EditText
    private lateinit var etB: EditText
    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtract)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivide = findViewById(R.id.btn_divide)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTV = findViewById(R.id.result_tv)

        // Set click listeners
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val a = etA.text.toString().toDoubleOrNull() ?: return
        val b = etB.text.toString().toDoubleOrNull() ?: return

        val result: Double = when (v?.id) {
            R.id.btn_add -> a + b
            R.id.btn_subtract -> a - b
            R.id.btn_multiply -> a * b
            R.id.btn_divide -> if (b != 0.0) a / b else Double.NaN
            else -> Double.NaN
        }

        resultTV.text = if (result.isNaN()) "Error: Division by zero" else "Result is $result"
    }
}
