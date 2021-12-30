package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)

        val btRegister = findViewById<Button>(R.id.btRegister)
        val btLogin = findViewById<Button>(R.id.btLogin)

        btRegister.setOnClickListener {
            val i = Intent(this@SplashActivity, RegisterActivity::class.java)
            startActivity(i)
        }
        btLogin.setOnClickListener {
            val i = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(i)
        }
    }
}