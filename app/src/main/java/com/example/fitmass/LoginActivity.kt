package com.example.fitmass

import DataBaseHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val pwPassword = findViewById<EditText>(R.id.pwPassword)
        val btLogin = findViewById<Button>(R.id.btSignIn)
        val btBack = findViewById<ImageButton>(R.id.btBack)

        val context = this
        btLogin.setOnClickListener{
            var usernameValue = ""
            var passwordValue = ""

            usernameValue = etUsername.text.toString()
            passwordValue = pwPassword.text.toString()

            if(usernameValue.length > 0 && passwordValue.length > 0){
                var args = listOf<String>(usernameValue, passwordValue).toTypedArray()
                var dbObj = DataBaseHelper(context)
                var db = dbObj.readableDatabase

                var result = db.rawQuery("SELECT * FROM Users WHERE username = ? AND password = ?", args)
                if(result.moveToNext())
                    Toast.makeText(context, "Welcome Back", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Please fill all data", Toast.LENGTH_SHORT).show()
            }
        }

        btBack.setOnClickListener{
            val i = Intent(this@LoginActivity, SplashActivity::class.java)
            startActivity(i)
        }
    }
}