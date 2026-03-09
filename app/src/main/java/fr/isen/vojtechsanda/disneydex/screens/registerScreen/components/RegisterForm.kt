package fr.isen.vojtechsanda.disneydex.screens.registerScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterForm() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Headers/////////////////
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start // Aligns text to the left
        ) {
            Text(
                text = "Create an account",
                fontSize = 25.sp,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 6.dp),
            )
            Text(
                text = "Register and join the Multiverse!",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 14.dp)
            )
        }
        //////////////////////////
        // Username Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = loginTextFieldColors(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.None
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))
        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = loginTextFieldColors(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))
        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            colors = loginTextFieldColors(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))
        // Confirm Password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            colors = loginTextFieldColors(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            isError = password.isNotEmpty() && confirmPassword.isNotEmpty() && password != confirmPassword
        )

        Spacer(modifier = Modifier.height(24.dp))
        // Register Button
        Button(
            onClick = { println("Registering with $email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { /* Navigate */ }) {
            Text("I already have an account. Log In.", color = Color.LightGray)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginTextFieldColors() = OutlinedTextFieldDefaults.colors(
    // Setting these to Transparent removes the "little background" box
    focusedContainerColor = Color.Transparent, unfocusedContainerColor = Color.Transparent,
    // Border colors (outline)
    focusedBorderColor = Color.Gray, unfocusedBorderColor = Color.Gray,
    // Text colors
    focusedTextColor = Color.Gray, unfocusedTextColor = Color.Gray,
    // Label colors
    focusedLabelColor = Color.Gray, unfocusedLabelColor = Color.Gray, errorLabelColor = Color.Red
)