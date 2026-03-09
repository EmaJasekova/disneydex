package fr.isen.vojtechsanda.disneydex.domain

import java.time.LocalDate

data class Movie(
    val name: String,
    val releaseDate: LocalDate?
)
