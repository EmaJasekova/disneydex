package fr.isen.vojtechsanda.disneydex.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun outlinedTextFieldColors() = OutlinedTextFieldDefaults.colors(
    // Setting these to Transparent removes the "little background" box
    focusedContainerColor = PaperColor,
    unfocusedContainerColor = PaperColor,

    // Border colors (outline)
    focusedBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    errorBorderColor = Color.Red,

    // Text colors
    focusedTextColor = Color.LightGray,
    unfocusedTextColor = Color.LightGray,
    errorTextColor = Color.LightGray,

    // Label colors
    focusedLabelColor = Color.LightGray,
    unfocusedLabelColor = Color.LightGray,
    errorLabelColor = Color.Red,
)

@Composable
fun DisneydexTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
