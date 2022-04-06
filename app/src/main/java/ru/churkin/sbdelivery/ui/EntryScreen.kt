package ru.churkin.sbdelivery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
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
                    textValue = "sidorov.ivan@mail.ru",
                    onValueChange = {},
                    inputType = KeyboardType.Email
                )

                BlockTextField(
                    title = "Пароль",
                    textValue = "•••••••",
                    onValueChange = {},
                    inputType = KeyboardType.Text,
                    spacerHeight = 56
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