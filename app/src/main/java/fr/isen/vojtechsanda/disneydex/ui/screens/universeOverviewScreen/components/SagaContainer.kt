package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import fr.isen.vojtechsanda.disneydex.ui.components.common.MovieCard

@Composable
fun SagaContainer(saga: Saga) {
    Column() {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .padding(bottom = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .background(Color.Red)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = saga.name,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            saga.movies.map { movie -> MovieCard(movie) }
        }
    }
}
