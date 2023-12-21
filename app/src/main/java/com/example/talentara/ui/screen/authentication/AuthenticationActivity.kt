package com.example.talentara.ui.screen.authentication

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talentara.ui.theme.TalentaraTheme

@Composable
fun AuthenticationScreen(
    modifier: Modifier = Modifier
) {
    val (selected, setSelected) = remember {
        mutableIntStateOf(0)
    }
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(bottom = 8.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        item {
            TopBar(selected, setSelected)
        }
        item {
            when (selected) {
                0 -> SignInTab()
                1 -> SignUpTab()
            }
        }
    }
}

@Composable
fun TopBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.height(193.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(193.dp)
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
                .padding(bottom = 32.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = CenterHorizontally,
        ) {
            CustomTab(
                items = listOf("Sign in", "Sign up"),
                selectedItemIndex = selectedTab,
                onClick = onTabSelected,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingUpPreview() {
    TalentaraTheme {
        SignUpTab()
    }
}



@Composable
fun SignUpTab(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
    ) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        var isError by remember { mutableStateOf(false) }

        fun validate(email: String) {
            isError = email.count() < 5
        }

        Text(
            text = "Welcome Back,",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        )
        Text(
            text = "Good to see you again",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(80.dp))
        OutlinedTextField(
            value = username,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "userIcon"
                )
            },
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Enter your username") },
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = email,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            onValueChange = {
                email = it
                isError = false
            },
            label = { Text(text = if (isError) "Email*" else "Email Address") },
            isError = isError,
            keyboardActions = KeyboardActions { validate(email) },
            placeholder = { Text(text = "Enter your e-mail") },
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .semantics {
                    if (isError) error("Email format is invalid.")
                }
        )
        OutlinedTextField(
            value = password,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "lockIcon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.Done else Icons.Default.Close,
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your password") },
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                        )
                    )
                )
                .clickable {  }
        ) {
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = modifier.align(alignment = Alignment.Center),
                fontSize = 24.sp
            )
        }
    }
}

@Composable
fun SignInTab(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }

        Text(
            text = "Welcome Back,",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        )
        Text(
            text = "Good to see you again",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(80.dp))
        OutlinedTextField(
            value = email,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                )
            },
            onValueChange = {
                email = it
            },
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter your e-mail") },
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = password,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "lockIcon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.Done else Icons.Default.Close,
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your password") },
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Forgot Password",
            modifier = modifier
                .align(alignment = Alignment.End),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(100.dp))
        Box(
            modifier = modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                        )
                    )
                )
                .clickable {  }
        ) {
            Text(
                text = "Login",
                color = MaterialTheme.colorScheme.secondaryContainer,
                modifier = modifier.align(alignment = Alignment.Center),
                fontSize = 24.sp
            )

        }
        Row(
            modifier = modifier
                .align(alignment = CenterHorizontally)
        ) {
            Text(
                text = "Don’t have account? ",
                fontSize = 16.sp
            )
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                modifier = modifier.clickable { }
            )
        }
    }
}

@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 150.dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing), label = "",
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.background)
            .height(60.dp),
    ) {
        MyTabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .align(Alignment.Center),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}

@Composable
private fun MyTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        animationSpec = tween(easing = LinearEasing), label = "",
    )
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
        text = text,
        color = tabTextColor,
        textAlign = TextAlign.Center,
        fontSize = 18.sp
    )
}

@Composable
private fun MyTabIndicator(
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(
                width = indicatorWidth,
            )
            .offset(
                x = indicatorOffset,
            )
            .clip(
                shape = RoundedCornerShape(20.dp),
            )
            .background(
                color = indicatorColor,
            ),
    )
}

@Preview(showBackground = true)
@Composable
fun SingInPreview() {
    TalentaraTheme {
        SignInTab()
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationScreenPreview() {
    TalentaraTheme {
        AuthenticationScreen()
    }
}