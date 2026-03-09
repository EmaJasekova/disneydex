package fr.isen.vojtechsanda.disneydex.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
    fun AppHeader (){


    Text(
        text = "DisneyDex",
        fontSize = 36.sp,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(bottom = 32.dp)
    )

}