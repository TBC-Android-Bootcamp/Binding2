package com.example.bindinghomework2.ui.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun initCount() {
        count.value = 0
    }

    fun increase(){
        count.value = count.value!! + 1
    }

    fun decrease(){
        count.value = count.value!!.minus(1)
    }

    fun count(): MutableLiveData<Int> {
        return count
    }

}