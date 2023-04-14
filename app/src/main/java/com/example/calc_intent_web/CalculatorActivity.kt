package com.example.calc_intent_web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    lateinit var Tv_answer: TextView
    lateinit var edt_firstnumber: EditText
    lateinit var edt_secondnumber: EditText
    lateinit var buttonadd: Button
    lateinit var buttonsubtract: Button
    lateinit var buttonmultiply: Button
    lateinit var buttondivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        Tv_answer = findViewById(R.id.Txt_Answer)
        edt_firstnumber = findViewById(R.id.Edt_Firstnum)
        edt_secondnumber = findViewById(R.id.Edt_Secondnum)
        buttonadd = findViewById(R.id.Btn_Add)
        buttonsubtract = findViewById(R.id.Btn_Sub)
        buttonmultiply = findViewById(R.id.Btn_Multiply)
        buttondivide = findViewById(R.id.Btn_Divide)

        buttonadd.setOnClickListener {
            var myfirstnumber = edt_firstnumber.text.toString()
            var mysecondnumber = edt_secondnumber.text.toString()

            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text = "Please fill in all inputs"

            }else{
                // lets now calculate
                var answer = myfirstnumber.toDouble() + mysecondnumber.toDouble()
                Tv_answer.text = answer.toString()
            }
        }

        buttonsubtract.setOnClickListener {
            var myfirstnumber = edt_firstnumber.text.toString()
            var mysecondnumber = edt_secondnumber.text.toString()

            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text = "Please fill in all inputs"

            }else{
                // lets now calculate
                var answer = myfirstnumber.toDouble() - mysecondnumber.toDouble()
                Tv_answer.text = answer.toString()
            }
        }

        buttonmultiply.setOnClickListener {
            var myfirstnumber = edt_firstnumber.text.toString()
            var mysecondnumber = edt_secondnumber.text.toString()

            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text = "Please fill in all inputs"

            }else{
                // lets now calculate
                var answer = myfirstnumber.toDouble() * mysecondnumber.toDouble()
                Tv_answer.text = answer.toString()
            }
        }
        buttondivide.setOnClickListener {
            var myfirstnumber = edt_firstnumber.text.toString()
            var mysecondnumber = edt_secondnumber.text.toString()

            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text = "Please fill in all inputs"

            }else{
                // lets now calculate
                var answer = myfirstnumber.toDouble() / mysecondnumber.toDouble()
                Tv_answer.text = answer.toString()
            }
        }

    }
}