package fr.isen.vojtechsanda.disneydex.ui.components.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.theme.outlinedTextFieldColors

@Composable
fun DexOutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = keyboardType == KeyboardType.Password,
    isError: Boolean = false
) {
    OutlinedTextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        colors = outlinedTextFieldColors(),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        isError = isError,
    )
}
