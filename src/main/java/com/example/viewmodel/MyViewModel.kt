package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel(){

    //private val text1 = MutableLiveData("Hello , Sourabh")
    private val counter = MutableLiveData<Int>(0)
  //  private val counter = Initialvalue

     val counterValue: LiveData<Int> = counter

//    fun updateText(newText: String){
//        text1.value = newText
//    }

    fun updateCounter(){
        counter.value = counter.value?.plus(1)
    }

    fun resetCounter(){
        counter.value = 0
    }

}