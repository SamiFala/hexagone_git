package com.wai.myapplication

data class CountryDTO (
    //DTO : Data Transfer Object
    val country : CountriesDto,
        )

data class CountriesDto(
    val name: String,
    val capital: String,
    val population: Int,
    val flags: FlagCountry,
    val region : String
)

data class FlagCountry(
    val svg : String,
    val png : String,
)