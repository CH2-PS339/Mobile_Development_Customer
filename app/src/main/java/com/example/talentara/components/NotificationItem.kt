package com.example.talentara.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.talentara.R

@Composable
fun NotificationItem (
    image: Painter,
    modifier: Modifier = Modifier,
    news: String,
    newsDetail: String
) {
    Row (
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .padding(end = 8.dp)
                .size(50.dp)
        )
        Column (
            modifier = modifier
        ) {
            Text (
                text = news,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = newsDetail
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItemPreview() {
    NotificationItem(
        image = painterResource(id = R.drawable.talentara_logo),
        news = "Welcome to Talentara",
        newsDetail = "Let's Find Your Project and Make Your Drem Come True"
    )
}