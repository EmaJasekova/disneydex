package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import kotlinx.coroutines.flow.Flow

interface SagaRepository {

    fun observeSagasByUniverse(universeId: String): Flow<List<Saga>>

    fun observeSaga(sagaId: String): Flow<Saga?>
}
