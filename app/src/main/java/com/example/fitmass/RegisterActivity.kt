package com.example.fitmass

import DataBaseHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        val btBack = findViewById<ImageButton>(R.id.btBack)
        val btRegister = findViewById<Button>(R.id.btSignUp)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val pwPassword = findViewById<EditText>(R.id.pwPassword)

        val context = this

        btBack.setOnClickListener{
            val i = Intent(this@RegisterActivity, SplashActivity::class.java)
            startActivity(i)
        }

        btRegister.setOnClickListener{
            var usernameValue = ""
            var emailValue = ""
            var passwordValue = ""

            usernameValue = etUsername.text.toString()
            emailValue = etEmail.text.toString()
            passwordValue = pwPassword.text.toString()

            if(usernameValue.length > 0 && emailValue.length > 0 &&
                passwordValue.length > 0){
                    var user = User(usernameValue, emailValue, passwordValue)
                    var db = DataBaseHelper(context)

                db.insertData(user)

                val i = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(i)
            }
            else{
                Toast.makeText(context, "Please fill all data", Toast.LENGTH_SHORT)
            }
        }
    }
}