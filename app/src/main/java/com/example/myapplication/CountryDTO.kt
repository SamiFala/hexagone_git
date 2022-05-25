package com.example.myapplication


data class CountryDTO(
    val name : String,
    val capital: String,
    val population: Int,
    val flags: FlagCountry,
    val region: String
)

data class FlagCountry(
    val png: String,
    val svg: String
)

