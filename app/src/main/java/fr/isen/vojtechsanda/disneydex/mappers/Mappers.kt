package fr.isen.vojtechsanda.disneydex.mappers

import fr.isen.vojtechsanda.disneydex.dto.MovieDto
import fr.isen.vojtechsanda.disneydex.dto.SagaDto
import fr.isen.vojtechsanda.disneydex.dto.UniverseDto
import fr.isen.vojtechsanda.disneydex.dto.UniversesDto
import fr.isen.vojtechsanda.disneydex.domain.Movie
import fr.isen.vojtechsanda.disneydex.domain.Saga
import fr.isen.vojtechsanda.disneydex.domain.Universe
import fr.isen.vojtechsanda.disneydex.domain.Universes
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DB_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

object Mappers {

    fun toMovie(dto: MovieDto): Movie = Movie(
        id = dto.id,
        name = dto.name,
        releaseDate = runCatching {
            LocalDate.parse(dto.releaseDate, DB_DATE_FORMAT)
        }.getOrNull()
    )

    fun toSaga(dto: SagaDto): Saga = Saga(
        name = dto.name,
        genre = dto.genre,
        movies = dto.movies.map(::toMovie)
    )

    fun toUniverse(dto: UniverseDto): Universe = Universe(
        name = dto.name,
        sagas = dto.sagas.map(::toSaga)
    )

    fun toUniverses(dto: UniversesDto): Universes = Universes(
        universes = dto.universes.map(::toUniverse)
    )
}
