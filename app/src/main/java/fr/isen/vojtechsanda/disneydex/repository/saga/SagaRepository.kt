package fr.isen.vojtechsanda.disneydex.repository.saga

import fr.isen.vojtechsanda.disneydex.domain.Saga
import kotlinx.coroutines.flow.Flow

interface SagaRepository {

    fun getSagasByUniverse(universeId: String): Flow<List<Saga>>

    fun getSaga(sagaId: String): Flow<Saga?>
}
