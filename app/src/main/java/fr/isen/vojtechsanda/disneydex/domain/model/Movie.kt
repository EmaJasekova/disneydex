package fr.isen.vojtechsanda.disneydex.domain.model

import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE
import java.time.LocalDate

data class Movie(
    val id: String,
    val name: String,
    val genre: String,
    val releaseDate: LocalDate,
    val posterImage: String = DEFAULT_POSTER_IMAGE
)