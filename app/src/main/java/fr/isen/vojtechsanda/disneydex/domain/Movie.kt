package fr.isen.vojtechsanda.disneydex.domain

import java.time.LocalDate

data class Movie(
    val id: String,
    val name: String,
    val releaseDate: LocalDate?
)
