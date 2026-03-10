package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.dto.UniverseDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn

object FirebaseUniverseRepository : UniverseRepository {

    private const val LOG_TAG = "FirebaseUniverseRepository"
    private const val REPLAY_TIMEOUT_MS = 5000L

    private val database = FirebaseDatabase.getInstance()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val universesRef = database.getReference("universes")

    private val universesFlow: Flow<List<Universe>> = createUniversesFlow()
        .catch { e ->
            Log.e(LOG_TAG, "Flow error", e)
            emit(emptyList())
        }
        .shareIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(REPLAY_TIMEOUT_MS),
            replay = 1
        )

    private fun createUniversesFlow(): Flow<List<Universe>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val universes = parseSnapshot(snapshot)
                trySend(universes)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(LOG_TAG, error.toString())
                trySend(emptyList())
            }
        }
        universesRef.addValueEventListener(listener)
        awaitClose { universesRef.removeEventListener(listener) }
    }

    private fun parseSnapshot(snapshot: DataSnapshot): List<Universe> = runCatching {
        snapshot.children
            .mapNotNull { child -> child.getValue(UniverseDto::class.java) }
            .map { dto -> dto.toUniverse() }
    }.getOrElse { e ->
        Log.e(LOG_TAG, "Failed to parse universes", e)
        emptyList()
    }

    override fun observeUniverses(): Flow<List<Universe>> = universesFlow

    override fun observeUniverse(universeId: String): Flow<Universe?> =
        observeUniverses().map { universes ->
            universes.find { universe -> universe.id == universeId }
        }
}
