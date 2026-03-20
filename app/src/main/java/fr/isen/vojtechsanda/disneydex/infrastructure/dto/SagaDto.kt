package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE
import fr.isen.vojtechsanda.disneydex.domain.model.Saga

data class SagaDto(
    val id: String = "",
    val name: String = "",
    val movies: List<MovieDto> = emptyList(),
    val imageUrl: String = "",
) {
    fun toSaga(): Saga = Saga(
        id,
        name,
        movies.map { movieDto -> movieDto.toMovie() },
        imageUrl = imageUrl.ifBlank { DEFAULT_POSTER_IMAGE }
    )
}
