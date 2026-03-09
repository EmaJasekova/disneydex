package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Universe

data class UniverseDto(
    val id: String = "",
    val name: String = "",
    val sagas: List<SagaDto> = emptyList()
) {
    fun toDomain(): Universe = Universe(
        id = id,
        name = name,
        sagas = sagas.map { sagaDto -> sagaDto.toDomain() }
    )
}
