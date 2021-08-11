package com.example.shopingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.recycler.CustomAdapter
import com.example.shopingapp.recycler.Lists
import com.example.shopingapp.recycler.OnButtonClick

class MainActivity : AppCompatActivity(),OnButtonClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = CustomAdapter(Lists().createList(),this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onButtonClicked() {
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }
}