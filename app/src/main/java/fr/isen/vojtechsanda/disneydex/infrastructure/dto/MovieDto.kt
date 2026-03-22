package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import android.util.Log
import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private const val LOG_TAG = "MovieDto"
private val DB_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

data class MovieDto(
    val id: String = "",
    val name: String = "",
    val genre: String = "",
    val duration: Int = 0,
    val releaseDate: String = "",
    val studio: String = "",
    val imageUrl: String = "",
) {
    fun toMovie(): Movie {
        val parsedDate = runCatching { LocalDate.parse(releaseDate, DB_DATE_FORMAT) }.getOrElse { e ->
            Log.w(LOG_TAG, "Invalid release date '$releaseDate' for movie '$id', using fallback", e)
            LocalDate.of(1970, 1, 1)
        }
        return Movie(
            id,
            name,
            genre,
            duration,
            parsedDate,
            studio,
            imageUrl = imageUrl.ifBlank { DEFAULT_POSTER_IMAGE }
        )
    }
}
