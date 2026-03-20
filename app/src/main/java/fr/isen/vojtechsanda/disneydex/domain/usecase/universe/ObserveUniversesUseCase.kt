package fr.isen.vojtechsanda.disneydex.domain.usecase.universe

import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import kotlinx.coroutines.flow.Flow

class ObserveUniversesUseCase(private val universeRepository: UniverseRepository) {

    operator fun invoke(): Flow<List<Universe>> = universeRepository.observeUniverses()
}
