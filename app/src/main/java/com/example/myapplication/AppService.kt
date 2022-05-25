package com.example.myapplication
import retrofit2.Response
import retrofit2.http.GET

@JvmSuppressWildcards

interface AppService {

    @GET("https://restcountries.com/v2/all")
    suspend fun getAllContries(): Response<List<CountryDTO>>?


}