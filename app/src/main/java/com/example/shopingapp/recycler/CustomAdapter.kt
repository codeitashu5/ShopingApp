package com.example.shopingapp.recycler

import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.MainActivity
import com.example.shopingapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CustomAdapter(val list:MutableList<Data>,val o:OnButtonClick) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
           val btn1 = itemView.findViewById<FloatingActionButton>(R.id.btn1)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_layout,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val img1 =  holder.itemView.findViewById<ImageView>(R.id.image)
        val img2 =  holder.itemView.findViewById<ImageView>(R.id.image1)
        img1.setImageResource(list[position].image1)
        img2.setImageResource(list[position].image2)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface OnButtonClick{
    fun onButtonClicked(b:Boolean)
}