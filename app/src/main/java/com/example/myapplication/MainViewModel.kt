package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //la ViewModel permet de garder en mémoire les informations tant que l'app est ouverte
    //var count: Int = 0
    var count: MutableLiveData<Int> = MutableLiveData(0 ) // is used for data that can evolve and that needs to be observed

    fun plus(){
        count.value = count.value?.plus(1)
    }
    fun moins(){
        count.value = count.value?.minus(1)
    }
    fun reset(){
        count.value = 0
    }
}