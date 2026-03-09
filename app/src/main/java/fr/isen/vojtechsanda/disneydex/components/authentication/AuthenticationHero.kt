package fr.isen.vojtechsanda.disneydex.components.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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

@Composable
fun AuthenticationHero(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.heroimagebackground)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color(0xFF333332)
                        )
                    )
                )
        )
        Text(
            text = "DisneyDex",
            fontSize = 50.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 72.dp)
                .align(Alignment.BottomCenter)
        )
    }
}