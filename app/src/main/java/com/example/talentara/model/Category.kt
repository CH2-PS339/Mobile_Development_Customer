package com.example.talentara.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.talentara.R

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
)

val MenuCategory = listOf(
    R.drawable.uiux_design_category to R.string.ui_ux_design_category,
    R.drawable.mobile_dev_category to R.string.mobile_dev_category,
    R.drawable.web_dev_category to R.string.web_dev_category
).map { Category(it.first, it.second) }