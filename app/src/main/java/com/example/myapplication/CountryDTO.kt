package com.example.myapplication

data class CountryDTO (
   val country: CountriesDto,
)

data class CountriesDto(
    val name: String,
    val capital: String,
    val population: Int,
    val flags: CountryFlag,
    val region: String
)

data class CountryFlag(
    val png: String,
)