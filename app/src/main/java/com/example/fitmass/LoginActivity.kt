package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity()
{
    private lateinit var dbAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        dbAuth = Firebase.auth

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val pwPassword = findViewById<EditText>(R.id.pwPassword)
        val btLogin = findViewById<Button>(R.id.btSignIn)
        val btBack = findViewById<ImageButton>(R.id.btBack)

        val context = this
        btLogin.setOnClickListener {
            var emailValue = ""
            var passwordValue = ""

            emailValue = etUsername.text.toString()
            passwordValue = pwPassword.text.toString()

            if (emailValue.isNotEmpty() && passwordValue.isNotEmpty())
            {
                signIn(emailValue, passwordValue)
            }
            else
            {
                Toast.makeText(context, "Incomplete credentials", Toast.LENGTH_SHORT).show()
            }
        }

        btBack.setOnClickListener {
            val i = Intent(this@LoginActivity, SplashActivity::class.java)
            startActivity(i)
        }
    }

    private fun signIn(email: String, password: String)
    {
        dbAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(
                        this@LoginActivity,
                        "Successfully Logged In",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            }
    }
}