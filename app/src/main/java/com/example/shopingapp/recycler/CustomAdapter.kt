package com.example.shopingapp.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopingapp.R

class CustomAdapter(val list:MutableList<Data>,val o:OnButtonClick) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            val btn1  = itemView.findViewById<Button>(R.id.btn1)
            val btn2  = itemView.findViewById<Button>(R.id.btn2)
            btn1.setOnClickListener {
                o.onButtonClicked()
            }
            btn2.setOnClickListener {
                o.onButtonClicked()
            }

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
    fun onButtonClicked()
}