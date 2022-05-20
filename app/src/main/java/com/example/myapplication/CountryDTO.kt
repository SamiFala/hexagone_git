package com.example.myapplication

import java.util.*

data class CountryDTO(
    val country: CountriesDTO
)

data class CountriesDTO(
    val name: String,
    val capital: String,
    val population: Int,
    val flags: FlagCountry,
    val region: String
)

data class FlagCountry(
    val png: String,
    val svg: String
)