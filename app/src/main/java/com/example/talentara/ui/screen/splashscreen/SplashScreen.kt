package com.example.talentara.ui.screen.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.talentara.R
import com.example.talentara.ui.main.TalentaraApp
import com.example.talentara.ui.navigation.Screen.Main
import com.example.talentara.ui.navigation.Screen.Splash
import com.example.talentara.ui.theme.TalentaraTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.talentara_logo),
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "TALENTARA",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate(Main.route) {
            popUpTo(Splash.route) {
                inclusive = true
            }
        }
    }
}
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Splash.route
    ) {
        composable(Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Main.route) {
            TalentaraApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TalentaraTheme {
        SplashScreen(navController =  rememberNavController())
    }
}