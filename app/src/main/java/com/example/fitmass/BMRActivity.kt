package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BMRActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_calorie)
        supportActionBar?.hide()

        val male = findViewById<RadioButton>(R.id.rdMale)
        val female = findViewById<RadioButton>(R.id.rdFemale)
        val genderGroup = findViewById<RadioGroup>(R.id.rgGender)
        val weight = findViewById<EditText>(R.id.etWeight)
        val height = findViewById<EditText>(R.id.etHeight)
        val age = findViewById<EditText>(R.id.etAge)
        val calculateButton = findViewById<Button>(R.id.btCalculateBMI2)
        val bmr = findViewById<TextView>(R.id.BMR)
        val bmrStatus = findViewById<TextView>(R.id.BMRStatus)
        val bmrView = findViewById<LinearLayout>(R.id.BMIView)
        var genderIndex: Int = 0
        val btBack = findViewById<Button>(R.id.btBack)
        btBack.setOnClickListener {
            val i = Intent(this@BMRActivity, DashboardActivity::class.java)
            i.putExtra("username", intent.getStringExtra("username"))
            i.putExtra("avatar", intent.getStringExtra("avatar"))
            startActivity(i)
        }
        genderGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rdMale)
            {
                genderIndex = 0
            }
            if (checkedId == R.id.rdFemale)
            {
                genderIndex = 1
            }
        }
        calculateButton.setOnClickListener {
            var weightValue = 0.0
            var heightValue = 0.0
            var ageValue: Int = 0
            if (weight.text.toString().isNotEmpty())
            {
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty())
            {
                heightValue = (height.text.toString().toDouble() / 100)
            }
            if (age.text.toString().isNotEmpty())
            {
                ageValue = age.text.toString().toInt()
            }
            if (weightValue > 0.0 && heightValue > 0.0 && ageValue > 0)
            {
                val bmiValue = String.format(
                    "%.2f",
                    calcBMRValue(weightValue, heightValue, ageValue, genderIndex)
                )
                bmr.text = bmiValue
                bmrView.visibility = VISIBLE
                calculateButton.visibility = VISIBLE
            }
            else
                Toast.makeText(this, "Invalid input value", Toast.LENGTH_LONG).show()
        }
    }

    private fun calcBMRValue(weight: Double, height: Double, age: Int, gender: Int): Double
    {
        var bmrValue: Double = when (gender)
        {
            0 -> 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
            1 -> 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
            else -> 0.0
        }

        return bmrValue
    }
}
