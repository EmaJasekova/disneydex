package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DB_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

data class MovieDto(
    val id: String = "",
    val name: String = "",
    val genre: String = "",
    val duration: Int = 0,
    val releaseDate: String = "",
    val studio: String = "",
) {
    fun toMovie(): Movie = Movie(
        id,
        name,
        genre,
        duration,
        // TODO: Handle parsing error
        LocalDate.parse(releaseDate, DB_DATE_FORMAT),
        studio
    )
}
