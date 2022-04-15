package ru.churkin.sbdelivery.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.churkin.sbdelivery.R
import ru.churkin.sbdelivery.items.BasketRow
import ru.churkin.sbdelivery.items.ButtonItem
import ru.churkin.sbdelivery.items.EntryToolBar
import ru.churkin.sbdelivery.view_models.BasketViewModel

@Composable
fun BasketScreen(
    vm: BasketViewModel = viewModel()
) {
    val state by vm.state.collectAsState()

    var counter by remember { mutableStateOf(0) }

    val colors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onSurface,
        disabledTextColor = MaterialTheme.colors.onBackground,
        placeholderColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
        focusedIndicatorColor = MaterialTheme.colors.secondary,
        cursorColor = MaterialTheme.colors.onSurface
    )

    Scaffold(
        topBar = {
            EntryToolBar(
                text = "Корзина",
                onClick = {}
            )
        }
    ) {
        ConstraintLayout() {
            val (lazyColumn, stock, price, button) = createRefs()

            LazyColumn(
                contentPadding = PaddingValues(bottom = 232.dp),
                modifier = Modifier
                    .constrainAs(lazyColumn) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                items(state.products, { it.id }) { item ->
                    BasketRow(product = item)
                    counter++
                    if (counter < state.products.size - 1) Divider(color = MaterialTheme.colors.onBackground)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(stock) {
                        top.linkTo(lazyColumn.bottom, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                    }
            ) {
                TextField(
                    value = state.promoCode,
                    onValueChange = { vm.updatePromoCode(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    textStyle = MaterialTheme.typography.body1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = colors
                )
                Spacer(modifier = Modifier.width(16.dp))

                ButtonItem(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF33313B)),
                    text = "Применить",
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onBackground,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 14.sp
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(price) {
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        bottom.linkTo(button.top, margin = 16.dp)
                    }
            ) {
                Text(
                    text = "Итого",
                    style = TextStyle(
                        color = MaterialTheme.colors.onPrimary,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 24.sp
                    )
                )
                Spacer(Modifier.weight(1f, true))
                Text(
                    text = "${state.totalPrice}",
                    style = TextStyle(
                        color = MaterialTheme.colors.secondary,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontSize = 24.sp
                    )
                )
            }
            ButtonItem(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(button) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                },
                text = "Оформить заказ",
                spacerHeight = 0
            )
        }

    }
}
