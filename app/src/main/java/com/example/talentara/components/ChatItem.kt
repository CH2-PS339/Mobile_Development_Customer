package com.example.talentara.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.talentara.R

@Composable
fun ChatItem (
    image: Painter,
    name: String,
    chat: String,
    date: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .size(50.dp)
            )
            Column (
                modifier = modifier,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = chat
                )
            }
        }
        Text(
            text = date,
            modifier = modifier.align(Alignment.TopEnd)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ChatItemPreview() {
    ChatItem(
        image = painterResource(id = R.drawable.david),
        name = "David Revivaldy",
        chat = "What's up?",
        date = "13:30"
    )
}