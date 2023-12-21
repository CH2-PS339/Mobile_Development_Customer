package com.example.talentara.ui.screen.addproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talentara.R
import com.example.talentara.components.TitleSection

@Composable
fun AddProjectScreen(
    modifier: Modifier = Modifier,
    navigateBack:() -> Unit,
    navigateBackToHome: () -> Unit
) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(bottom = 8.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        item {
            TopBar(onBackClick = navigateBack)
        }
        item {
            TitleSection(
                title = "Category",
                content = { CategoryInput("Enter your project category") }
            )
        }
        item {
            TitleSection(
                title = "Title",
                content = { CategoryInput("Enter your project title") }
            )
        }
        item {
            TitleSection(
                title = "Description",
                content = { CategoryInput("Enter your project description") }
            )
        }
        item {
            TitleSection(
                title = "When is your deadline?",
                content = { CategoryInput("Enter your project deadline") }
            )
        }
        item {
            TitleSection(
                title = "Expected Cost",
                content = { CategoryInput("Enter your expected cost") }
            )
        }
        item {
            UploadButton(navigateBackToHome = navigateBackToHome)
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onBackClick:() -> Unit
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
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
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box (
            modifier = modifier
                .size(45.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable { onBackClick() },
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_btn),
                contentDescription = null,
                modifier = modifier
                    .align(Center),
            )
        }
    }
}

@Composable
fun CategoryInput (
    textInput: String,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    OutlinedTextField(
        value = title,
        onValueChange = { title = it },
        label = { Text(text = textInput) },
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun UploadButton (
    modifier: Modifier = Modifier,
    navigateBackToHome: () -> Unit
) {
    Spacer(modifier = Modifier.height(40.dp))
    Row (
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.primary)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                        )
                    )
                )
                .clickable { navigateBackToHome() },
        ) {
            Text(
                text = "Upload",
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = modifier
                    .align(alignment = Center)
                    .padding(16.dp),
                fontSize = 24.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AddProjectPreview() {
    AddProjectScreen( navigateBack = {}, navigateBackToHome = {})
}