package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.ui.components.form.DexOutlinedTextField

@Composable
fun SearchMovie() {
    var query by remember { mutableStateOf("") }

    val mockMovies = listOf(
        "Thor: Love and Thunder",
        "Iron Man",
        "Black Panther",
        "Spider-Man: No Way Home",
        "Avengers: Endgame",
        "Doctor Strange",
        "Captain America",
        "Guardians of the Galaxy"
    )

    val filtered = mockMovies.filter { it.contains(query, ignoreCase = true) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        DexOutlinedTextField(
            label = "Search movies...",
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = Icons.Default.Search
        )

        if (query.isNotEmpty()) {
            filtered.forEach { title ->
                Text(
                    text = title,
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { query = title }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}