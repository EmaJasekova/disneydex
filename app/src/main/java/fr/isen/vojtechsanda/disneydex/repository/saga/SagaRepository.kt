package fr.isen.vojtechsanda.disneydex.repository.saga

import fr.isen.vojtechsanda.disneydex.domain.Saga
import kotlinx.coroutines.flow.Flow

interface SagaRepository {

    fun observeSagasByUniverse(universeId: String): Flow<List<Saga>>

    fun observeSaga(sagaId: String): Flow<Saga?>
}
