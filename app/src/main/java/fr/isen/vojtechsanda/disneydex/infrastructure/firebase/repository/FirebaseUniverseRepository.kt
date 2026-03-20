package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseConstants
import fr.isen.vojtechsanda.disneydex.infrastructure.dto.UniverseDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class FirebaseUniverseRepository : UniverseRepository {

    private companion object {
        const val LOG_TAG = "FirebaseUniverseRepository"
    }

    private val universesRef = FirebaseDatabase.getInstance().getReference(FirebaseConstants.Paths.UNIVERSES)

    override fun observeUniverses(): Flow<List<Universe>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    trySend(parseSnapshot(snapshot))
                } catch (e: Exception) {
                    trySend(emptyList())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(LOG_TAG, error.toString())
                close(error.toException())
            }
        }
        universesRef.addValueEventListener(listener)
        awaitClose { universesRef.removeEventListener(listener) }
    }.catch { e ->
        // TODO(Medium): Catch-and-rethrow adds no value - either handle meaningfully or remove catch block.
        Log.e(LOG_TAG, "Flow error", e)
        throw e
    }

    override fun observeUniverse(universeId: String): Flow<Universe?> =
        observeUniverses().map { universes ->
            universes.find { universe -> universe.id == universeId }
        }

    private fun parseSnapshot(snapshot: DataSnapshot): List<Universe> = runCatching {
        snapshot.children
            .mapNotNull { child -> child.getValue(UniverseDto::class.java) }
            .map { dto -> dto.toUniverse() }
    }.getOrElse { e ->
        Log.e(LOG_TAG, "Failed to parse universes", e)
        throw e
    }
}
