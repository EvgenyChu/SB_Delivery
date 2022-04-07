package ru.churkin.sbdelivery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.churkin.sbdelivery.R
import ru.churkin.sbdelivery.items.BlockTextField
import ru.churkin.sbdelivery.items.ButtonItem
import ru.churkin.sbdelivery.items.EntryToolBar
import ru.churkin.sbdelivery.items.TextButtonItem

@Composable
fun EntryScreen() {
    var login: String by remember { mutableStateOf("Sidorov") }
    var password: String by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            EntryToolBar(
                text = "Вход",
                onClick = {}
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop,
                contentDescription = "background"
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                BlockTextField(
                    title = "E-mail",
                    value = login,
                    onValueChange = {login = it},
                    inputType = KeyboardType.Email
                )

                BlockTextField(
                    title = "Пароль",
                    value = password,
                    onValueChange = {password = it},
                    spacerHeight = 56,
                    inputType = KeyboardType.Password
                )

                ButtonItem(
                    onClick = {},
                    text = "Войти",
                )

                TextButtonItem(
                    onClick = {},
                    text = "Регистрация"
                )

                Spacer(modifier = Modifier.height(56.dp))
            }
            TextButton(
                onClick = { },
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Забыли пароль?",
                    style = MaterialTheme.typography.h2
                )
            }
        }
    }
}

@Preview
@Composable
fun Entry() {
    EntryScreen()
}