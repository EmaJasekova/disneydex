package fr.isen.vojtechsanda.disneydex.ui.components.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DexAutocomplete() {
    var query by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

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

    ExposedDropdownMenuBox(
        expanded = expanded && filtered.isNotEmpty(),
        onExpandedChange = { expanded = it }
    ) {
        DexOutlinedTextField(
            label = "Search movies...",
            value = query,
            onValueChange = {
                query = it
                expanded = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryEditable),
            leadingIcon = Icons.Default.Search,
            shape = RoundedCornerShape(10.dp),
            contentDescription = "Search Movie"
        )

        ExposedDropdownMenu(
            expanded = expanded && filtered.isNotEmpty(),
            onDismissRequest = { expanded = false }
        ) {
            filtered.forEach { title ->
                DropdownMenuItem(
                    text = { Text(title) },
                    onClick = {
                        query = title
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}