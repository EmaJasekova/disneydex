package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.moviesAutocomplete

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.form.DexAutocomplete

@Composable
fun MoviesAutocomplete(
    placeholder: String? = null,
    label: String? = null,
    onSelected: (Movie) -> Unit,
    viewModel: MoviesAutocompleteViewModel = viewModel()
) {
    val query by viewModel.searchQuery.collectAsState()
    val suggestions by viewModel.suggestions.collectAsState()

    DexAutocomplete(
        label = label,
        placeholder = placeholder,
        query = query,
        onQueryChange = { viewModel.onQueryChange(it) },
        options = suggestions,
        getTitle = { it.name },
        onSelected = onSelected,
    )
}
