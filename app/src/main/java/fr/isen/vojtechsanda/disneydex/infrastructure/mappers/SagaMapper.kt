package fr.isen.vojtechsanda.disneydex.infrastructure.mappers

import fr.isen.vojtechsanda.disneydex.domain.Saga
import fr.isen.vojtechsanda.disneydex.dto.SagaDto

object SagaMapper {

    fun fromDto(dto: SagaDto): Saga = Saga(
        name = dto.name,
        genre = dto.genre,
        movies = dto.movies.map { movieDto -> MovieMapper.fromDto(movieDto) }
    )

    fun toDto(saga: Saga): SagaDto = SagaDto(
        name = saga.name,
        genre = saga.genre,
        movies = saga.movies.map { movie -> MovieMapper.toDto(movie) }
    )
}
