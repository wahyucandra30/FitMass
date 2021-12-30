package com.example.fitmass

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ArticleViewActivity : AppCompatActivity()
{
    //private lateinit var dbReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_articleview)

        val btBack: ImageButton = findViewById(R.id.btArticleBack)

        btBack.setOnClickListener {
            val i = Intent(this@ArticleViewActivity, DashboardActivity::class.java)
            startActivity(i)
        }
        //dbReference = FirebaseDatabase.getInstance("Users")
    }
}