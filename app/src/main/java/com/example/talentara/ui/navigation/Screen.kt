package com.example.talentara.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Order : Screen("order")
    object Profile : Screen("profile")
    object Activity : Screen("activity")
}
