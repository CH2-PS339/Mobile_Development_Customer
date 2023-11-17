package com.example.talentara.ui.screen.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.talentara.ui.navigation.Screen
import com.example.talentara.ui.theme.TalentaraTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToMain: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
    ) {
        Text(
            text = "Talentara",
            fontSize = 32.sp,
            modifier = modifier.align(alignment = Alignment.Center),
            color = MaterialTheme.colorScheme.secondaryContainer
        )
    }
    LaunchedEffect(key1 = true) {
        delay(3000) // Tunggu selama 3 detik (sesuaikan sesuai kebutuhan)
        navigateToMain()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TalentaraTheme {
        SplashScreen(navigateToMain = { Screen.Home.route })
    }
}