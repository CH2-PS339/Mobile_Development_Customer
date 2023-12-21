package com.example.talentara.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.talentara.R
import com.example.talentara.ui.theme.MustardDark

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    based: String,
    cost: String,
    status: String,
    date: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = modifier
                .align(Alignment.CenterStart),
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .padding(end = 8.dp)
                    .size(100.dp)
            )
            Box {
                Column(
                    modifier = modifier
                        .align(Alignment.TopStart)
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = based
                    )
                    Text(
                        text = cost
                    )
                }
            }
        }
        Text(
            text = status,
            modifier = modifier
                .align(Alignment.BottomCenter)
        )
        Text(
            text = date,
            modifier = modifier
                .align(Alignment.TopEnd)
        )
        Card (
            modifier = modifier
                .align(Alignment.BottomEnd)
                .width(56.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(MustardDark)
        ) {
            Text(
                text = "Rate",
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = modifier
                    .padding(4.dp)
                    .align(CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistorItemPreview() {
    HistoryItem(
        image = painterResource(id = R.drawable.talentara_logo),
        title = "Talentara",
        based = "Mobile Android Application",
        cost = "Rp. 7.000.000",
        status = "Project Complete",
        date = "22/11/2023"
    )
}