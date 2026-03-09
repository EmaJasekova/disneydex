package fr.isen.vojtechsanda.disneydex.components.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.R
import fr.isen.vojtechsanda.disneydex.ui.theme.BackgroundColor

@Composable
fun AuthenticationHero(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.heroimagebackground)

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.Transparent,
                            0.5f to Color.Transparent,
                            1.0f to BackgroundColor
                        )
                    )
                )
        ) {
            Text(
                text = "Disneydex",
                fontSize = 52.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}
