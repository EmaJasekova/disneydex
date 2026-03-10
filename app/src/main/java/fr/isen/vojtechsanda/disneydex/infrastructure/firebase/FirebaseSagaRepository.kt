package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object FirebaseSagaRepository : SagaRepository {

    override fun observeAllSagas(): Flow<List<Saga>> =
        FirebaseUniverseRepository.observeUniverses().map { universes ->
            universes.flatMap { universe -> universe.sagas }
        }

    override fun observeSagasByUniverse(universeId: String): Flow<List<Saga>> =
        FirebaseUniverseRepository.observeUniverse(universeId).map { universe ->
            universe?.sagas ?: emptyList()
        }

    override fun observeSaga(sagaId: String): Flow<Saga?> =
        FirebaseUniverseRepository.observeUniverses().map { universes ->
            universes.firstNotNullOfOrNull { universe ->
                universe.sagas.find { saga -> saga.id == sagaId }
            }
        }
}
