package com.wai.myapplication

import retrofit2.Response
import retrofit2.http.GET

@JvmSuppressWildcards
interface AppService {

    @GET("https://restcountries.com/v2/all")

    //Appel de la fonction d'une manière Asynchrone
    suspend fun getAllCountries():  Response<List<CountryDTO>>?



}