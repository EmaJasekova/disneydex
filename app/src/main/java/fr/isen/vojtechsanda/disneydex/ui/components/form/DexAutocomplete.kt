package fr.isen.vojtechsanda.disneydex.ui.components.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DexAutocomplete(
    placeholder: String? = null,
    label: String? = null,
    options: List<T>,
    getTitle: (T) -> String,
    onSelected: (T) -> Unit,
    onQueryChange: (String) -> Unit,
    query: String,
) {
    val focusManager = LocalFocusManager.current

    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded && options.isNotEmpty(),
        onExpandedChange = { expanded = it }
    ) {
        DexOutlinedTextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
                expanded = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryEditable),
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Movie"
                )
            },
            placeholder = placeholder,
            label = label,
        )

        ExposedDropdownMenu(
            expanded = expanded && options.isNotEmpty(),
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(getTitle(option)) },
                    onClick = {
                        onQueryChange("")
                        expanded = false
                        onSelected(option)

                        focusManager.clearFocus()
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}
