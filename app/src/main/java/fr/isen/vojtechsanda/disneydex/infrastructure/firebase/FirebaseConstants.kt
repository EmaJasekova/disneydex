package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType

// TODO(High): FirebaseConstants mixes paths (Paths) with mapping logic (MovieListKeys, toFirebaseKey). Split into Paths object and separate mapping module.
object FirebaseConstants {

    object Paths {
        const val USERS = "users"
        const val MOVIE_TRADERS = "movieTraders"
        const val UNIVERSES = "universes"
    }

    object MovieListKeys {
        const val WATCHED = "watched"
        const val WATCHLIST = "watchList"
        const val OWNED = "owned"
        const val FOR_TRADE = "forTrade"
    }

    fun MovieListType.toFirebaseKey(): String = when (this) {
        MovieListType.WATCHED -> MovieListKeys.WATCHED
        MovieListType.WATCHLIST -> MovieListKeys.WATCHLIST
        MovieListType.OWNED -> MovieListKeys.OWNED
        MovieListType.FOR_TRADE -> MovieListKeys.FOR_TRADE
    }
}
