package fr.isen.vojtechsanda.disneydex.domain.usecase.universe

import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import kotlinx.coroutines.flow.Flow

class ObserveUniverseUseCase(private val universeRepository: UniverseRepository) {

    operator fun invoke(universeId: String): Flow<Universe?> =
        universeRepository.observeUniverse(universeId)
}
