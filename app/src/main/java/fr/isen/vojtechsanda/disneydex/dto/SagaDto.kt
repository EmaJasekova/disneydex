package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Saga

data class SagaDto(
    val id: String = "",
    val name: String = "",
    val genre: String = "",
    val movies: List<MovieDto> = emptyList()
) {
    fun toDomain(): Saga = Saga(
        id = id,
        name = name,
        genre = genre,
        movies = movies.map { movieDto -> movieDto.toDomain() }
    )
}
