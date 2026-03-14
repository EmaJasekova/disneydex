package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.model.Universe

data class UniverseDto(
    val id: String = "",
    val name: String = "",
    val sagas: List<SagaDto> = emptyList(),
    val description: String = ""
) {
    fun toUniverse(): Universe = Universe(
        id,
        name,
        sagas.map { sagaDto -> sagaDto.toSaga() },
        description
    )
}
