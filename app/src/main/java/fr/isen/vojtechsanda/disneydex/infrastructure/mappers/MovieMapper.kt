package fr.isen.vojtechsanda.disneydex.infrastructure.mappers

import fr.isen.vojtechsanda.disneydex.domain.Movie
import fr.isen.vojtechsanda.disneydex.dto.MovieDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DB_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

object MovieMapper {

    fun fromDto(dto: MovieDto): Movie = Movie(
        id = dto.id,
        name = dto.name,
        releaseDate = runCatching {
            LocalDate.parse(dto.releaseDate, DB_DATE_FORMAT)
        }.getOrNull()
    )

    fun toDto(movie: Movie): MovieDto = MovieDto(
        id = movie.id,
        name = movie.name,
        releaseDate = movie.releaseDate?.format(DB_DATE_FORMAT) ?: ""
    )
}
