package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Universe

data class UniverseDto(
    val id: String = "",
    val name: String = "",
    val sagas: List<SagaDto> = emptyList()
) {
    fun toUniverse(): Universe = Universe(
        id,
        name,
        sagas.map { sagaDto -> sagaDto.toSaga() }
    )
}
