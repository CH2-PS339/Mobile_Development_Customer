package com.example.talentara.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talentara.R
import com.example.talentara.ui.theme.MustardLight
import com.example.talentara.ui.theme.TalentaraTheme

@Composable
fun HomeScreen(
    navigateToAddproject: () -> Unit
) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(bottom = 8.dp),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        item {
            TopBar()
        }
        item {
            Slogan()
        }
        item {
            HomeMenu(navigateToAddproject = navigateToAddproject)
        }
        item {
            Advestisement()
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(170.dp)
            .clip(
                RoundedCornerShape(
                    bottomStart = 26.dp,
                    bottomEnd = 26.dp
                )
            )
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
    ) {
        Text(
            text = "TALENTARA",
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = MustardLight,
        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        Text(
            text = "Hi, David",
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        Text(
            text = "Hope you have a nice day !",
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
    }
}

@Composable
fun Slogan(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .border(4.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(26.dp))
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Let's make your dream\nproject come true !",
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = painterResource(id = R.drawable.web_dev_category),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun HomeMenu (
    modifier: Modifier = Modifier,
    navigateToAddproject: () -> Unit
) {
    Row (
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = modifier
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ongoing),
                contentDescription = null,
                modifier = modifier
                    .size(72.dp)
            )
            Text(
                text = "Ongoing",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
        Column (
            modifier = modifier
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.latest),
                contentDescription = null,
                modifier = modifier
                    .size(72.dp)
            )
            Text(
                text = "Latest",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
        Column (
            modifier = modifier
                .clickable {
                    navigateToAddproject()
                }
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.web_dev_category),
                contentDescription = null,
                modifier = modifier
                    .size(72.dp)
            )
            Text(
                text = "New",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Advestisement(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { },
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome),
                contentDescription = null,
            )
            Text(
                text = "Welcome to Talentara",
                modifier = modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "A Game-Changing Digital Platform that Connects IT Experts with Customers Looking for IT services.",
                modifier = modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                fontSize = 12.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TalentaraTheme {
        HomeScreen {}
    }
}