package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components.sagaSection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import fr.isen.vojtechsanda.disneydex.routing.Route
import fr.isen.vojtechsanda.disneydex.ui.components.common.MovieCard

fun LazyListScope.sagaSection(
    itemGroupModifier: Modifier = Modifier,
    navController: NavHostController,
    saga: Saga
) {
    item { SagaSectionTitle(itemGroupModifier, saga.name) }

    itemsIndexed(
        items = saga.movies,
        key = { _, movie -> movie.id }
    ) { index, movie ->
        Column(itemGroupModifier) {
            MovieCard(movie, onClick = { navController.navigate(Route.MovieDetail(movie.id)) })

            if (index != saga.movies.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
