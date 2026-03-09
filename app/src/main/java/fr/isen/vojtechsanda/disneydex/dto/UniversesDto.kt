package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Universes

data class UniversesDto(
    val universes: List<UniverseDto> = emptyList()
) {
    fun toDomain(): Universes = Universes(
        universes = universes.map { universeDto -> universeDto.toDomain() }
    )
}
