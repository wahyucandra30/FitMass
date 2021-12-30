package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.UserProfileChangeRequest

import com.google.firebase.auth.FirebaseUser




class RegisterActivity : AppCompatActivity()
{
    private lateinit var dbReference: DatabaseReference
    private lateinit var dbAuth: FirebaseAuth
    private lateinit var btBack: ImageButton
    private lateinit var btRegister: Button
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var pwPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        dbReference = FirebaseDatabase.getInstance().getReference("users")
        dbAuth = Firebase.auth

        btBack = findViewById<ImageButton>(R.id.btBack)
        btRegister = findViewById<Button>(R.id.btSignUp)
        etUsername = findViewById<EditText>(R.id.etUsername)
        etEmail = findViewById<EditText>(R.id.etEmail)
        pwPassword = findViewById<EditText>(R.id.pwPassword)

        val context = this

        btBack.setOnClickListener {
            val i = Intent(this@RegisterActivity, SplashActivity::class.java)
            startActivity(i)
        }

        btRegister.setOnClickListener {
            var usernameValue = ""
            var emailValue = ""
            var passwordValue = ""

            usernameValue = etUsername.text.toString()
            emailValue = etEmail.text.toString()
            passwordValue = pwPassword.text.toString()

            if (usernameValue.isNotEmpty() && emailValue.isNotEmpty() &&
                passwordValue.isNotEmpty()
            )
            {
                createUser(usernameValue, emailValue, passwordValue)
            }
            else
            {
                Toast.makeText(context, "Please fill all data", Toast.LENGTH_SHORT)
            }
        }
    }

    private fun createUser(username: String, email: String, password: String)
    {
        val userInput = UserData(username, email, password)
        val userId = dbReference.push().key.toString()
        dbReference.child(userId).setValue(userInput).addOnCompleteListener {
            etUsername.setText("")
            etEmail.setText("")
            pwPassword.setText("")
        }
        dbAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                {
                    val user = FirebaseAuth.getInstance().currentUser

                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(username).build()

                    user.updateProfile(profileUpdates)

                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()
                    val i = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(i)
                    finish()
                }
                else
                {
                    Toast.makeText(this, "Password is not strong enough", Toast.LENGTH_LONG).show()
                }
            }
    }
}