package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DashboardActivity : AppCompatActivity()
{
private lateinit var dbAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dashboard)

        dbAuth = Firebase.auth

        val tvAvatar = findViewById<TextView>(R.id.tvAvatar)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val btSignOut = findViewById<TextView>(R.id.btSignOut)
        val btBMI = findViewById<ImageButton>(R.id.btCalculator)
        val btBMR = findViewById<ImageButton>(R.id.btCalorie)
        val btMenu = findViewById<ImageButton>(R.id.btMenu)
        val btArticles = findViewById<ImageButton>(R.id.btArticle)

        val displayName: String = dbAuth.currentUser.displayName
        val initials: String = displayName.substring(0, 1)
        tvAvatar.text = initials
        tvUsername.text = displayName

        btSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val i = Intent(this@DashboardActivity, SplashActivity::class.java)
            startActivity(i)
        }
        btBMI.setOnClickListener {
            val i = Intent(this@DashboardActivity, BMIActivity::class.java)
            startActivity(i)
        }

        btBMR.setOnClickListener {
            val i = Intent(this@DashboardActivity, BMRActivity::class.java)
            startActivity(i)
        }
        btMenu.setOnClickListener {
            val i = Intent(this@DashboardActivity, MenuRecActivity::class.java)
            startActivity(i)
        }
        btArticles.setOnClickListener {
            val i = Intent(this@DashboardActivity, ArticleViewActivity::class.java)
            startActivity(i)
        }
    }
}