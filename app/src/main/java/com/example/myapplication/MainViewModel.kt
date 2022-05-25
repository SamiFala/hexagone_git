package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.invoke.MutableCallSite

class MainViewModel : ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder()//on attribut le retrofit
        .baseUrl("https://restcountries.com/")//départ sans paramètres
        .addConverterFactory(GsonConverterFactory.create())//transformer du gson
    .build()

    val appService: AppService = retrofit.create(AppService::class.java)//créer une instance du fichier AppService

    var count : MutableLiveData<Int> = MutableLiveData(0)
    var error : MutableLiveData<Boolean> = MutableLiveData(false)
    var countries : MutableLiveData<List<CountryDTO>> = MutableLiveData(emptyList())

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

    fun getAllCountries() {
        viewModelScope.launch {
            val response = appService.getAllCountries()
            if (response == null || !response.isSuccessful){//il va vérifier qur tout ça diff de null sinon il sorts
                return@launch
            }
            // si le code arrive ici c'est que tout est ok
            val body = response.body()// on a la liste des pays
            body?.forEach {
                println("this country is ${it.name}")
            }
            println("Here is my DATA $body")
            countries.value = body

        }
    }
    }






