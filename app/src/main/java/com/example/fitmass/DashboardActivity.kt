package com.example.fitmass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dashboard)

        val tvAvatar = findViewById<TextView>(R.id.tvAvatar)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val btSignOut = findViewById<TextView>(R.id.btSignOut)
        val btBMI = findViewById<ImageButton>(R.id.btCalculator)
        val btBMR = findViewById<ImageButton>(R.id.btCalorie)

        tvAvatar.text = intent.getStringExtra("avatar")
        tvUsername.text = intent.getStringExtra("username")

        btSignOut.setOnClickListener{
            val i = Intent(this@DashboardActivity, SplashActivity::class.java)
            startActivity(i)
        }
        btBMI.setOnClickListener{
            val i = Intent(this@DashboardActivity, BMIActivity::class.java)
            i.putExtra("username",intent.getStringExtra("username"));
            i.putExtra("avatar",intent.getStringExtra("avatar"));
            startActivity(i)
        }

        btBMR.setOnClickListener{
            val i = Intent(this@DashboardActivity, BMRActivity::class.java)
            i.putExtra("username",intent.getStringExtra("username"));
            i.putExtra("avatar",intent.getStringExtra("avatar"));
            startActivity(i)
        }
    }
}