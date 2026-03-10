package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.domain.model.Universes
import kotlinx.coroutines.flow.Flow

interface UniverseRepository {

    fun observeUniverses(): Flow<Universes>

    fun observeUniverse(universeId: String): Flow<Universe?>
}
