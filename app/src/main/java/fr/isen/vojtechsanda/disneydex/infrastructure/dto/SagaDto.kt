package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.model.Saga

data class SagaDto(
    val id: String = "",
    val name: String = "",
    val genre: String = "",
    val movies: List<MovieDto> = emptyList()
) {
    fun toSaga(): Saga = Saga(
        id,
        name,
        genre,
        movies.map { movieDto -> movieDto.toMovie() }
    )
}
