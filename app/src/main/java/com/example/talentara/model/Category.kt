package com.example.talentara.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import com.example.talentara.R

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int,
    @ColorRes val color1: Int,
    @ColorRes val color2: Int
)

val MenuCategory = listOf(
    Pair(R.drawable.uiux_design_category, R.string.ui_ux_design_category) to Pair(R.color.blue_light, R.color.blue_dark),
    Pair(R.drawable.mobile_dev_category, R.string.mobile_dev_category) to Pair(R.color.mustard_dark, R.color.mustard_light),
    Pair(R.drawable.web_dev_category, R.string.web_dev_category) to Pair(R.color.blue_light, R.color.blue_dark),
    Pair(R.drawable.web_dev_category, R.string.game_dev_category) to Pair(R.color.mustard_dark, R.color.mustard_light)
).map {
    val (image, text) = it.first
    val (color1, color2) = it.second
    Category(image, text, color1, color2)
}