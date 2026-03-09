package fr.isen.vojtechsanda.disneydex.repository.universe

import fr.isen.vojtechsanda.disneydex.domain.Universe
import fr.isen.vojtechsanda.disneydex.domain.Universes
import kotlinx.coroutines.flow.Flow

interface UniverseRepository {

    fun getUniverses(): Flow<Universes>

    fun getUniverse(universeId: String): Flow<Universe?>
}
