package com.example.talentara.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talentara.R
import com.example.talentara.model.HomeSection
import com.example.talentara.ui.theme.MustardDark
import com.example.talentara.ui.theme.TalentaraTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(bottom = 8.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        item {
            TopBar(painterResource(id = R.drawable.david))
        }
        item {
            HomeSection(
                title = "Personal Detail",
                content = { PersonalDetail() }
            )
        }
        item {
            HomeSection(
                title = "Account Settings",
                content = { AccountSettings() }
            )
        }
        item {
            HomeSection(
                title = "Security",
                content = { Security() }
            )
        }
        item {
            HomeSection(
                title = "Application Settings",
                content = { ApplicationSettings() }
            )
        }
        item {
            HomeSection(
                title = "About Us",
                content = { AboutUs() }
            )
        }
        item {
            Logout()
        }
    }
}

@Composable
fun TopBar(
    painter: Painter,
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier.height(400.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(225.dp)
                .align(Alignment.TopCenter)
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
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.profile),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painter,
                contentDescription = "Profile Photo",
                modifier = modifier
                    .size(180.dp)
                    .border(8.dp, MaterialTheme.colorScheme.background, CircleShape)
                    .clip(CircleShape)
            )
            Text(
                text = "David Revivady",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier.padding(top = 8.dp)
            )
            Text(
                text = "@davidrvii",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Column(
                modifier = modifier
                    .clip(CircleShape)
                    .background(MustardDark)
                    .clickable { },
            ) {
                Row(
                    modifier = modifier
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = modifier.size(16.dp)
                    )
                    Text(
                        text = "Edit",
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = modifier.padding(start = 4.dp, end = 4.dp),
                        fontSize = 14.sp
                    )
                }

            }
        }
    }
}

@Composable
fun PersonalDetail(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Profile",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "E-KTP",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "NPWP",
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun AccountSettings(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Change Company Information",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ",
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun Security(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Change Password",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ",
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun ApplicationSettings(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Language",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Notification",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = " ",
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun AboutUs(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Contact Us",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Terms and Conditions",
                modifier = modifier
                    .padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.background,
            thickness = 1.dp,
            modifier = modifier.padding(start = 8.dp, end = 8.dp)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Privacy Policy",
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun Logout(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .clickable {  },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { }
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = null,
                tint = Color.Red,
                modifier = modifier.padding(8.dp)
            )
            Text(
                text = "logout",
                color = Color.Red,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    TalentaraTheme {
        PersonalDetail()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    TalentaraTheme {
        ProfileScreen()
    }
}