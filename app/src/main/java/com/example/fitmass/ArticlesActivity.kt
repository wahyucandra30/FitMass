package com.example.fitmass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference

class ArticlesActivity : AppCompatActivity()
{
    private lateinit var dbReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dashboard)


        //dbReference = FirebaseDatabase.getInstance("Users")
    }
}