package com.example.talentara.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talentara.R
import com.example.talentara.ui.theme.MustardDark
import com.example.talentara.ui.theme.MustardLight
import com.example.talentara.ui.theme.TalentaraTheme

@Composable
fun CategoryItem(
    category: Category,
    color1: Color,
    color2: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(26.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            color1,
                            color2,
                        )
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(category.textCategory),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            Image(
                painter = painterResource(category.imageCategory),
                contentDescription = null,
                modifier = modifier.padding(4.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    TalentaraTheme {
        CategoryItem(
            category = Category(
                R.drawable.uiux_design_category,
                R.string.ui_ux_design_category,
            ),
            color1 = MustardDark,
            color2 = MustardLight
        )
    }
}