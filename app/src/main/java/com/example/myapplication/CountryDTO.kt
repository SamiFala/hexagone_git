package com.example.myapplication

class CountryDTO (
//DTO to Data Transfer Object
    val country: CountriesDto,

)

data class CountriesDto (
val name: String,
val capital: String,
val population: Int,
val flags: FlagCountry,
val region: String
)


data class FlagCountry (
    val png: String,
    val svg: String,

        )