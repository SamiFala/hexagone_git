package com.example.myapplication

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel () {

    var count: MutableLiveData<Int> = MutableLiveData(0)
    var error: MutableLiveData<Boolean> = MutableLiveData(false)

    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun moins() {
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

    fun initError() {
        error.value = false
    }
}