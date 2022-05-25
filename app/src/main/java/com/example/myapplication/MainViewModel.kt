package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val retrofit: Retrofit.Builder()
                        .baseUrl("https://restcountries.com/v2/")
                        .addConverterFactory(GsonConvertFactory.create())
                        .build()

    val appService : AppService = Retrofit.create(AppService::class.java)
    var count : MutableLiveData<Int> = MutableLiveData(0)
    var error : MutableLiveData<Boolean> = MutableLiveData(false)
    var countries : MutableLiveData<List<CountryDTO>> = MutableLiveData(emptyList())

    fun plus(){
        count.value = count.value?.plus(1)
    }

    fun moins(){
        count.value?.let {
            if (it > 0) count.value = count.value?.minus(1)
        }
    }
    fun getAllCountries(){
        viewModelScope.launch {
            val response = appService.getAllCountries(){
                if (response == null || response.isSuccessful){
                    return@launch
                }
                val body = response.body()
                println("Here is my data $body")
                countries.value = body
            }
        }
    }

}