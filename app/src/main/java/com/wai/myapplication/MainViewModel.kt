package com.wai.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainViewModel : ViewModel() {


    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val appService : AppService = retrofit.create(AppService::class.java)


    //Implémentation du Live Data :  pour observer l'évolution de la donnée
    var count: MutableLiveData<Int> = MutableLiveData(0)
    var error: MutableLiveData<Boolean> = MutableLiveData(false)

    var countries:MutableLiveData<List<CountryDTO>> = MutableLiveData(emptyList())

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

    fun getAllCountries(){
        viewModelScope.launch {
            val response = appService.getAllCountries()
            if(response == null || !response.isSuccessful){
                return@launch
            }
            // Sinon, c'est Ok
            // Récupération du contenu

            val body = response.body()
            body?.forEach{
                println("THIS COUNTRY ${it.name}")

        }
            println(body)
            countries.value = body


        }
    }

}