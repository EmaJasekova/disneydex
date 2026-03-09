package fr.isen.vojtechsanda.disneydex.dto

import fr.isen.vojtechsanda.disneydex.domain.Universes

data class UniversesDto(
    val universes: List<UniverseDto> = emptyList()
) {
    fun toUniverses(): Universes = Universes(
        universes.map { universeDto -> universeDto.toUniverse() }
    )
}
