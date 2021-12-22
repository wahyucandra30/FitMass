package com.example.fitmass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.*
import com.example.fitmass.R
import kotlin.math.pow

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_bmi)
        supportActionBar?.hide()

        val male = findViewById<RadioButton>(R.id.rdMale)
        val female = findViewById<RadioButton>(R.id.rdFemale)
        val genderGroup = findViewById<RadioGroup>(R.id.rgGender)
        val weight = findViewById<EditText>(R.id.etWeight)
        val height = findViewById<EditText>(R.id.etHeight)
        val calculateButton = findViewById<Button>(R.id.btCalculateBMI)
        val bmi = findViewById<TextView>(R.id.BMI)
        val bmiStatus = findViewById<TextView>(R.id.BMIStatus)
        val bmiView = findViewById<LinearLayout>(R.id.BMIView)
        val btBack = findViewById<Button>(R.id.btBack)

        bmiStatus.visibility = View.INVISIBLE

        btBack.setOnClickListener{
            val i = Intent(this@BMIActivity, DashboardActivity::class.java)
            i.putExtra("username",intent.getStringExtra("username"));
            i.putExtra("avatar",intent.getStringExtra("avatar"));
            startActivity(i)
        }

        genderGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rdMale) {
                Toast.makeText(this, male.text.toString(), Toast.LENGTH_SHORT).show()
            }
            if (checkedId == R.id.rdFemale) {
                Toast.makeText(this, female.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        calculateButton.setOnClickListener {
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight.text.toString().isNotEmpty()) {
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty()) {
                heightValue = (height.text.toString().toDouble() / 100)
            }
            if (weightValue > 0.0 && heightValue > 0.0) {
                val bmiValue = String.format("%.2f", weightValue / heightValue.pow(2))
                bmi.text = bmiValue
                bmiStatus.text = bmiStatusValue(weightValue / heightValue.pow(2))
                bmiStatus.visibility = View.VISIBLE
                bmiView.visibility = VISIBLE
                calculateButton.visibility = VISIBLE
            } else
                Toast.makeText(this, "Please Input Weight and Height Values greater than 0", Toast.LENGTH_LONG).show()
        }

    }

    private fun bmiStatusValue(bmi: Double): String {
        var bmiStatus: String = when {
            bmi < 18.5 -> "Underweight"
            bmi >= 18.5 && bmi < 25 -> "Normal"
            bmi >= 25 && bmi < 30 -> "Overweight"
            bmi > 30 -> "Obese"
            else -> "Status"

        }
        return bmiStatus
    }
}
