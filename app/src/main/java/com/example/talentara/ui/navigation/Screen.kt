package com.example.talentara.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object authentication : Screen("authentication")
    object Main : Screen("main")
    object Home : Screen("home")
    object Order : Screen("order")
    object Profile : Screen("profile")
    object Activity : Screen("activity")
    object AddProject : Screen("addproject")
}
