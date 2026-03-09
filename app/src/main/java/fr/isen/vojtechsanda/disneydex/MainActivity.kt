package fr.isen.vojtechsanda.disneydex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.RegisterScreen
import fr.isen.vojtechsanda.disneydex.ui.theme.BackgroundColor
import fr.isen.vojtechsanda.disneydex.ui.theme.DisneydexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisneydexTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //we use 0xFF then add the color code in hex format
                    containerColor = BackgroundColor
                ) { innerPadding ->
//                    LoginScreen(modifier = Modifier.padding(innerPadding))
                    RegisterScreen(modifier = Modifier.padding(
                        top = 0.dp,
                        bottom = innerPadding.calculateBottomPadding()
                        )
                    )
                }
            }
        }
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    //Use this to be able to read from database, use TAG to see the message in the logcat
    companion object {
        private const val TAG = "MainActivity"
    }
}
