package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FirebaseSagaRepository(
    private val universeRepository: UniverseRepository
) : SagaRepository {

    override fun observeAllSagas(): Flow<List<Saga>> =
        universeRepository.observeUniverses().map { universes ->
            universes.flatMap { universe -> universe.sagas }
        }

    override fun observeSagasByUniverse(universeId: String): Flow<List<Saga>> =
        universeRepository.observeUniverse(universeId).map { universe ->
            universe?.sagas ?: emptyList()
        }

    override fun observeSaga(sagaId: String): Flow<Saga?> =
        universeRepository.observeUniverses().map { universes ->
            universes.firstNotNullOfOrNull { universe ->
                universe.sagas.find { saga -> saga.id == sagaId }
            }
        }
}
