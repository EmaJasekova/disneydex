package fr.isen.vojtechsanda.disneydex.ui.components.common.hero

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.ui.theme.AppBackgroundColor

@Composable
fun Hero(
    modifier: Modifier = Modifier,
    imageRes: Int? = null,
    imageUrl: String? = null,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(300.dp)
            .then(modifier.fillMaxWidth())
    ) {
        if (imageRes != null)
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

        if (imageUrl != null)
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

        Column(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.Transparent,
                            0.3f to Color.Transparent,
                            1.0f to AppBackgroundColor
                        )
                    )
                )
        ) {
            content()
        }
    }
}
