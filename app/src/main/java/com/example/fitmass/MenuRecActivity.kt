package com.example.fitmass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MenuRecActivity : AppCompatActivity(), OnclickItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_menurec)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun init(){
        recyclerView = findViewById(R.id.recycler_view)

        var data = ArrayList<Menu>()

        data.add(Menu(R.drawable.apel, "Apel", "100 kcal", "10 gram", "50gram", "20 gram"))
        data.add(Menu(R.drawable.brocoli, "Broccoli", "100 kcal", "10 gram", "50gram", "20 gram"))
        data.add(Menu(R.drawable.caisim, "Caisim", "100 kcal", "10 gram", "50gram", "20 gram"))
        data.add(Menu(R.drawable.spinach, "Spinach", "100 kcal", "10 gram", "50gram", "20 gram"))
        data.add(Menu(R.drawable.wspinach, "Water Spinach", "100 kcal", "10 gram", "50gram", "20 gram"))
        data.add(Menu(R.drawable.tomato, "Tomato", "100 kcal", "10 gram", "50gram", "20 gram"))

        adapter = MyAdapter(data)
    }

    override fun onItemClick(item: Menu, position: Int) {

    }
}