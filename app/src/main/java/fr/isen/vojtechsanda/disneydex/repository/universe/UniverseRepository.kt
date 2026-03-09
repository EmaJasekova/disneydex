package fr.isen.vojtechsanda.disneydex.repository.universe

import fr.isen.vojtechsanda.disneydex.domain.Universe
import fr.isen.vojtechsanda.disneydex.domain.Universes
import kotlinx.coroutines.flow.Flow

interface UniverseRepository {

    fun observeUniverses(): Flow<Universes>

    fun observeUniverse(universeId: String): Flow<Universe?>
}
