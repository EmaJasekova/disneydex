package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseConstants
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

class FirebaseMovieRepository(
    private val sagaRepository: SagaRepository
) : MovieRepository {

    private companion object {
        const val LOG_TAG = "FirebaseMovieRepository"
        const val MAX_SUGGESTIONS = 10
    }

    private val movieForTradeRef = FirebaseDatabase.getInstance().getReference(FirebaseConstants.Paths.MOVIE_TRADERS)

    override fun observeMoviesBySaga(sagaId: String): Flow<List<Movie>> =
        sagaRepository.observeSaga(sagaId).map { saga ->
            saga?.movies ?: emptyList()
        }

    // TODO(High): Inefficient load-all-then-filter - loads all sagas to find one movie. Consider direct path or indexed lookup.
    override fun observeMovie(movieId: String): Flow<Movie?> =
        sagaRepository.observeAllSagas().map { sagas ->
            sagas.firstNotNullOfOrNull { saga ->
                saga.movies.find { movie -> movie.id == movieId }
            }
        }

    // TODO(High): Inefficient load-all-then-filter - loads all sagas to find one movie. Consider direct path or indexed lookup.
    override fun observeMovies(movieIds: List<String>): Flow<List<Movie?>> =
        // TODO(High): Find solution on how to keep the order of the movies sync with the ids.
        sagaRepository.observeAllSagas().map { sagas ->
            sagas.flatMap { saga ->
                saga.movies.filter { movie -> movieIds.contains(movie.id) }
            }
        }

    override fun searchMovieSuggestions(query: String): Flow<List<Movie>> =
        sagaRepository.observeAllSagas().map { sagas ->
            val trimmed = query.trim()
            if (trimmed.length < 2) return@map emptyList()
            val allMovies = sagas.flatMap { saga -> saga.movies }
            allMovies
                .filter { movie -> movie.name.contains(trimmed, ignoreCase = true) }
                .take(MAX_SUGGESTIONS)
        }

    /**
     * Since Firebase cannot search through all users to see who wants to trade a movie,
     * we listen directly to the denormalized "movieForTrade" node.
     */
    override fun observeMovieTraders(movieId: String): Flow<List<String>> = callbackFlow {
        val ref = movieForTradeRef.child(movieId)
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val uids = snapshot.children.mapNotNull { child -> child.key }
                trySend(uids)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(LOG_TAG, error.toString())
                close(error.toException())
            }
        }
        ref.addValueEventListener(listener)
        awaitClose { ref.removeEventListener(listener) }
    }
}
