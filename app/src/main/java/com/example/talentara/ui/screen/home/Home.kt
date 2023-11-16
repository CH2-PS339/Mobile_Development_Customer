package com.example.talentara.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.talentara.data.Repository
import com.example.talentara.model.CategoryItem
import com.example.talentara.model.HomeSection
import com.example.talentara.model.MenuCategory
import com.example.talentara.ui.theme.MustardLight
import com.example.talentara.ui.theme.TalentaraTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(bottom = 8.dp),
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        item {
            TopBar()
        }
        item {
            Advertisement()
        }
        item {
            HomeSection(
                title = "Our Services",
                content = { CategoryColumn() }
            )
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(
            Repository()
        )
    )
) {
    val query by viewModel.query

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(225.dp)
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
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        Text(
            text = "lorem ipsum",
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        SearchBar(
            query = query,
            onQueryChange = viewModel::search
        )
    }
}


@Composable
fun Advertisement(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .clickable {  },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ADVERSTISEMENT",
                color = MaterialTheme.colorScheme.secondaryContainer
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text(text = "Cari project")
        },
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 8.dp)
            .fillMaxWidth()
            .heightIn(min = 24.dp)
    ) {
    }
}

@Composable
fun CategoryColumn(
) {
    val menuCategories = MenuCategory
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        menuCategories.forEach { category ->
            CategoryItem(category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TalentaraTheme {
        TopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TalentaraTheme {
        HomeScreen()
    }
}