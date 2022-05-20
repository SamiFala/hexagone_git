package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var count: MutableLiveData<Int> = MutableLiveData(0)


    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun minus() {
        count.value = count.value?.minus(1)

        if (count.value?.minus(1)!! < 1) {
            count.value = 0
        }

    }
}