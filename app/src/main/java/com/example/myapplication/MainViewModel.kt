package com.example.myapplication

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val retrofit: Retrofit = Retrofit
        .Builder().baseUrl("https://restcountries.com/v2/")
        .addConverterFactory((GsonConverterFactory.create()))
        .build()

    val appService: AppService = retrofit.create(AppService::class.java)

    var count: MutableLiveData<Int> = MutableLiveData(0)
    var error: MutableLiveData<Boolean> = MutableLiveData(false)
    var contries: MutableLiveData<List<CountryDTO>> = MutableLiveData(listOf())

    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun moins() {
        count.value?.let {
            if (it >= 1) {
                count.value = count.value?.minus(1)
            } else {
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

    fun getAllContries() {
        viewModelScope.launch {
            var response = appService.getAllContries()
            if (response == null || !response.isSuccessful) {
                return@launch
            }
            val body = response.body()
            println("Here is my Data $body")
            contries.value = body
        }

    }
}
