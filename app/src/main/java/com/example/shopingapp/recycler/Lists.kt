package com.example.shopingapp.recycler

import com.example.shopingapp.R

class Lists {
    val list = mutableListOf<Data>()
    val listImage = listOf<Data>(
        Data(R.drawable.jerse5,R.drawable.jersey3),
        Data(R.drawable.jersey4,R.drawable.jersey1),
        Data(R.drawable.jersey1,R.drawable.jersey3),
        Data(R.drawable.jersery2,R.drawable.jerse5),
        Data(R.drawable.jersey3,R.drawable.jersey4)
    )

   public fun createList() : MutableList<Data> {
        for (i in 0..99) {
            list.add(listImage[(0..4).random()])
        }
       return list
    }
}