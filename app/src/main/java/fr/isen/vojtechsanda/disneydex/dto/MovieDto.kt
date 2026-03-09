package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DB_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

data class MovieDto(
    val id: String = "",
    val name: String = "",
    val releaseDate: String = ""
) {
    fun toDomain(): Movie = Movie(
        id = id,
        name = name,
        releaseDate = runCatching {
            LocalDate.parse(releaseDate, DB_DATE_FORMAT)
        }.getOrNull()
    )
}
