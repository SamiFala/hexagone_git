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

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val appService : AppService = retrofit.create(AppService::class.java)

    var count: MutableLiveData<Int> = MutableLiveData(0)
    var error:  MutableLiveData<Boolean> = MutableLiveData(false)
    var countries:  MutableLiveData<List<CountryDTO>> = MutableLiveData(emptyList())

    fun plus() {
        count.value = count.value?.plus(1)
    }

    fun minus() {
        count.value?.let {
            if (it > 0 ) {
                count.value = count.value?.minus(1)
            }
            else{
                error.value = true
            }
        }
    }

    fun reset () {
        count.value = 0
    }


    fun getAllCountries() {
        viewModelScope.launch {
            val response = appService.getAllCountries()
            if (response == null || !response.isSuccessful) {
                return@launch
            }
            // si le code arrive ici c'est que tout est ok
            val body = response.body()

            body?.forEach {
                println("my country ${it.name}")
            }
            println("here is my data $body")
            countries.value = body
        }
    }
}
