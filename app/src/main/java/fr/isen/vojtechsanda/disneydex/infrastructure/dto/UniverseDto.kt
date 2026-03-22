package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE
import fr.isen.vojtechsanda.disneydex.domain.model.Universe

data class UniverseDto(
    val id: String = "",
    val name: String = "",
    val sagas: List<SagaDto> = emptyList(),
    val description: String = "",
    val imageUrls: List<String> = emptyList(),
) {
    fun toUniverse(): Universe = Universe(
        id,
        name,
        sagas.map { sagaDto -> sagaDto.toSaga() },
        description,
        imageUrls = imageUrls.ifEmpty {
            listOf(DEFAULT_POSTER_IMAGE)
        }
    )
}
