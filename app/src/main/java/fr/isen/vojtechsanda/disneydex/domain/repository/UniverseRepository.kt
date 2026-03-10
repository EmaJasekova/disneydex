package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import kotlinx.coroutines.flow.Flow

interface UniverseRepository {

    fun observeUniverses(): Flow<List<Universe>>

    fun observeUniverse(universeId: String): Flow<Universe?>
}
