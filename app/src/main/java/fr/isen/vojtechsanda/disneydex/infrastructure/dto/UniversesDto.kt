package fr.isen.vojtechsanda.disneydex.infrastructure.dto

import fr.isen.vojtechsanda.disneydex.domain.model.Universes

data class UniversesDto(
    val universes: List<UniverseDto> = emptyList()
) {
    fun toUniverses(): Universes = Universes(
        universes.map { universeDto -> universeDto.toUniverse() }
    )
}
