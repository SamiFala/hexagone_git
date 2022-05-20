package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.invoke.MutableCallSite

class MainViewModel : ViewModel() {

    var count : MutableLiveData<Int> = MutableLiveData(0)
    var error : MutableLiveData<Boolean> = MutableLiveData(false)
    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun minus() {
        count.value?.let {
            if (it >= 1) {
                count.value = count.value?.minus(1)
            }
            else{
                error.value = true
            }
        }
        }



    fun reset() {
        count.value = 0
    }
    }




