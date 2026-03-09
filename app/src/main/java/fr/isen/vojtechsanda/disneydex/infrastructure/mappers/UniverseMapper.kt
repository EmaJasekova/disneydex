package fr.isen.vojtechsanda.disneydex.infrastructure.mappers

import fr.isen.vojtechsanda.disneydex.domain.Universe
import fr.isen.vojtechsanda.disneydex.dto.UniverseDto

object UniverseMapper {

    fun fromDto(dto: UniverseDto): Universe = Universe(
        id = dto.id,
        name = dto.name,
        sagas = dto.sagas.map { sagaDto -> SagaMapper.fromDto(sagaDto) }
    )
}
