package com.wai.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Implémentation du Live Data :  pour observer l'évolution de la donnée
    var count: MutableLiveData<Int> = MutableLiveData(0)
    var error: MutableLiveData<Boolean> = MutableLiveData(false)

    fun plus(){
        count.value = count.value?.plus(1)
    }

    fun moins(){
        count.value?.let {
            if (it > 0 ){
                count.value = count.value?.minus(1)
                error.value = false
            }else{
                error.value = true
            }
        }


    }

    fun reset(){
        count.value = 0
    }


}