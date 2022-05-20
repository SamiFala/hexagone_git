package com.wai.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Implémentation du Live Data :  pour observer l'évolution de la donnée
    var count: MutableLiveData<Int> = MutableLiveData(0)

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