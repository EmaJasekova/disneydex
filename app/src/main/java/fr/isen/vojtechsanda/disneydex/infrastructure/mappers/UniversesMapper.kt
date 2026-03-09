package fr.isen.vojtechsanda.disneydex.infrastructure.mappers

import fr.isen.vojtechsanda.disneydex.domain.Universes
import fr.isen.vojtechsanda.disneydex.dto.UniversesDto

object UniversesMapper {

    fun fromDto(dto: UniversesDto): Universes = Universes(
        universes = dto.universes.map { universeDto -> UniverseMapper.fromDto(universeDto) }
    )

    fun toDto(universes: Universes): UniversesDto = UniversesDto(
        universes = universes.universes.map { universe -> UniverseMapper.toDto(universe) }
    )
}
