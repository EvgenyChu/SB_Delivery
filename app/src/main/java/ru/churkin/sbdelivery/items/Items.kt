package ru.churkin.sbdelivery.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.churkin.sbdelivery.R

@Composable
fun EntryToolBar(
    text: String = "",
    actions: List<IconButton> = emptyList(),
    leftIcon: Int = R.drawable.ic_baseline_arrow_back_24,
    onClick: () -> Unit
) {
    TopAppBar(backgroundColor = MaterialTheme.colors.primary) {
        IconButton(onClick = { onClick() }) {
            Icon(
                painter = painterResource(id = leftIcon),
                tint = MaterialTheme.colors.secondary,
                contentDescription = "Назад"
            )
        }
        Text(
            text,
            style = MaterialTheme.typography.h1,
        )
        Spacer(Modifier.weight(1f, true))

        actions.forEach {
            IconButton(onClick = { it.action }) {
                Icon(
                    painter = painterResource(id = it.icon),
                    tint = it.tint,
                    contentDescription = "Поиск"
                )
            }
        }
    }
}

data class IconButton(
    val icon: Int,
    val action: () -> Unit,
    val tint: Color
)

@Composable
fun BlockTextField(
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    spacerHeight: Int = 16,
    textValue: String = "",
    onValueChange: () -> Unit,
    inputType: KeyboardType = KeyboardType.Text,

    ) {
    val colors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onSurface,
        backgroundColor = MaterialTheme.colors.surface,
        focusedIndicatorColor = MaterialTheme.colors.onSurface,
        cursorColor = MaterialTheme.colors.onSurface
    )

    Text(
        text = title,
        style = titleStyle
    )
    Spacer(modifier = Modifier.height(8.dp))
    TextField(
        value = textValue,
        onValueChange = { onValueChange() },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(8.dp),
        textStyle = MaterialTheme.typography.body1,
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        colors = colors
    )
    Spacer(modifier = Modifier.height(spacerHeight.dp))
}

@Composable
fun ButtonItem(
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
    text: String = "",
    textStyle: TextStyle = MaterialTheme.typography.h1,
    spacerHeight: Int = 16
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(8.dp),
        colors = colors
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
    Spacer(modifier = Modifier.height(spacerHeight.dp))
}

@Composable
fun TextButtonItem(
    onClick: () -> Unit,
    text: String = ""
){
    TextButton(
        onClick = {onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onPrimary)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h1
        )
    }
}

