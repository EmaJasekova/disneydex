package fr.isen.vojtechsanda.disneydex.components.authentication

import android.R.id.message
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.R

@Composable

fun AuthenticationHero(modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.heroimagebackground)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "DisneyDex",
            fontSize = 36.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 32.dp)
        )
    }
}