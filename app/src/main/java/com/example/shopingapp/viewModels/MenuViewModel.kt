package com.example.shopingapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {
    private val _price =  MutableLiveData<Int>(0)
    private val _jerseys =  MutableLiveData<Int>(0)

    //backing these properties so we can use them in the fragment
    val price : LiveData<Int> get() = _price
     val jerseys : LiveData<Int> get() = _jerseys


    fun increasePrice(){
        _price.value = _price.value!! + 50
    }
     fun decreasePrice(){
        _price.value = _price.value!! - 50
    }
    fun increaseJerseys(){
        _jerseys.value = _jerseys.value!! + 1
    }
    fun decreaseJerseys(){
        _jerseys.value = _jerseys.value!! - 1
    }


}