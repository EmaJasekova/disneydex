package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType

fun MovieListType.toFirebaseKey(): String = when (this) {
    MovieListType.WATCHED -> "watched"
    MovieListType.WATCHLIST -> "watchList"
    MovieListType.OWNED -> "owned"
    MovieListType.FOR_TRADE -> "forTrade"
}
