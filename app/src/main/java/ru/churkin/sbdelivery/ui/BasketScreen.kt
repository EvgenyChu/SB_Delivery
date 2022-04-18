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
import androidx.constraintlayout.compose.Dimension
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


    Scaffold(
        topBar = {
            EntryToolBar(
                text = "Корзина",
                onClick = {}
            )
        }
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (lazyColumn, stock, price, button) = createRefs()

            LazyColumn(
                modifier = Modifier
                    .constrainAs(lazyColumn) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(stock.top)
                        height = Dimension.fillToConstraints
                    }
            ) {
                items(state.products, { it.id }) { item ->
                    BasketRow(product = item)
                    counter++
                    if (state.products.indexOf(item) < state.products.size - 1) Divider(
                        Modifier.height(1.dp),
                        color = Color(0xFF2C2C33)
                    )
                }
            }

            PromoCode(
                onValueChange = {},
                code = state.promoCode,
                modifier = Modifier
                    .constrainAs(stock) {
                        top.linkTo(lazyColumn.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            )

            Row(
                modifier = Modifier
                    .constrainAs(price) {
                        top.linkTo(stock.bottom, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        bottom.linkTo(button.top, margin = 16.dp)
                        width = Dimension.fillToConstraints
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
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(button) {
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                        width = Dimension.fillToConstraints
                    },
                text = "Оформить заказ",
                spacerHeight = 0
            )
        }

    }
}

@Composable
fun PromoCode(
    code: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onPrimary,
        disabledTextColor = Color(0xFF33313B),
        placeholderColor = Color(0xFF33313B),
        backgroundColor = MaterialTheme.colors.background,
        focusedIndicatorColor = Color(0xFF33313B),
        cursorColor = MaterialTheme.colors.onPrimary
    )

    Row(
        modifier = modifier
    ) {
        TextField(
            value = code,
            onValueChange = onValueChange,
            modifier = Modifier
                .height(56.dp)
                .weight(5f),
            textStyle = TextStyle(
                color = MaterialTheme.colors.onPrimary,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontSize = 14.sp
            ),
            placeholder = {
                Text(
                    "Введите промокод",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 14.sp
                    )
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = colors
        )

        ButtonItem(
            onClick = {},
            modifier = Modifier
                .weight(3f)
                .height(44.dp)
                .padding(start = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF33313B)),
            text = "Применить",
            textStyle = TextStyle(
                color = MaterialTheme.colors.onBackground,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontSize = 14.sp
            ),
            spacerHeight = 0
        )
    }
}
