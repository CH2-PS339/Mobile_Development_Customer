package com.example.talentara.ui.navigation

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val title: String,
    val icon: Painter,
    val screen: Screen,
    val selectedIcon: Painter,
    val selected: Boolean = false,
)
