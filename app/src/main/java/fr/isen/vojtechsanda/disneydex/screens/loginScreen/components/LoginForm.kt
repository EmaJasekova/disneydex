package fr.isen.vojtechsanda.disneydex.screens.loginScreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginForm (){

    // State for the input fields
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Text(
        text = "Login to your account",
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(bottom = 32.dp)
    )

    // Email Field
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Password Field
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Login Button
    Button(
        onClick = {
            /* Handle login logic here */
            println("Logging in with $email")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text("Login")
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Register Button (Secondary)
    TextButton(
        onClick = { /* Navigate to Register */ }
    ) {
        Text("Don't have an account? Sign Up")
    }
}