package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var calculateBtn: Button
    private lateinit var tvResult: TextView
    private lateinit var tvResultText: TextView
private lateinit var  cvResult: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        calculateBtn = findViewById(R.id.calculateBtn)
        tvResult = findViewById(R.id.tvResult)
        tvResultText = findViewById(R.id.tvResultText)
        cvResult = findViewById(R.id.cvResult)



        calculateBtn.setOnClickListener{
            if (etHeight.text == null && etWeight.text == null){
                Toast.makeText(this,"Please enter your weight and height", Toast.LENGTH_SHORT).show()
            } else{

                getBmi()
            }
        }
    }


    fun getBmi(){

        val enteredWeight = etWeight.text.toString().toDouble()
        val enteredHeight = etHeight.text.toString().toDouble()

        val heightInMeters = enteredHeight / 100

        val meterSqr = heightInMeters * heightInMeters

        val bmi = enteredWeight/meterSqr

        val number3digits:Double = String.format("%.3f", bmi).toDouble()
        val bmi2digits:Double = String.format("%.2f", number3digits).toDouble()


        tvResult.text = bmi2digits.toString()

       bmiCategories(bmi2digits)

    }

    fun bmiCategories(a:Double){

        if ( a > 0 && a < 18.5){
            tvResultText.text = "You are underweight"
            cvResult.setCardBackgroundColor(ContextCompat.getColor(this, R.color.unhealthy))
            Toast.makeText(this,"You are underweight, Bro eat some pizza!", Toast.LENGTH_SHORT).show()
        } else if( a > 18.5 && a < 24.9){
            tvResultText.text = "You are Healthy"
            cvResult.setCardBackgroundColor(ContextCompat.getColor(this, R.color.healthy))
            Toast.makeText(this,"You are Healthy, Keep it up Bro!", Toast.LENGTH_SHORT).show()
        }else if( a > 25.0 &&  a < 29.9){

            tvResultText.text = "You are Overweight"
            cvResult.setCardBackgroundColor(ContextCompat.getColor(this, R.color.unhealthy))
            Toast.makeText(this,"Bro you are Overweight,cut some weight", Toast.LENGTH_SHORT).show()
        } else{
            tvResultText.text = "You are Obese"
            cvResult.setCardBackgroundColor(ContextCompat.getColor(this, R.color.unhealthy))
            Toast.makeText(this,"Bro you are Obese, do something before its too late", Toast.LENGTH_SHORT).show()
        }
    }
}