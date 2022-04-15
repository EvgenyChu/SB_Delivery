package ru.churkin.sbdelivery.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import ru.churkin.sbdelivery.R
import ru.churkin.sbdelivery.items.ButtonItem
import ru.churkin.sbdelivery.items.CardReview
import ru.churkin.sbdelivery.items.EntryToolBar


@Composable
fun DishScreen() {

    var isFavorite: Boolean by remember { mutableStateOf(false) }
    var counter: Int by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            EntryToolBar(
                text = "Пицца Маргарита",
                onClick = {}
            )
        }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            val (image, stock, icon, title, text, oldPrice, newPrice, box, button, reviews) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.pizza),
                contentScale = ContentScale.Fit,
                contentDescription = "background",
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = "АКЦИЯ",
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.onError,
                        shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .constrainAs(stock) {
                        top.linkTo(image.top, margin = 16.dp)
                    },
                style = MaterialTheme.typography.overline,
            )

            Icon(
                painter = painterResource(
                    id = if (!isFavorite) R.drawable.ic_baseline_favorite_border_24
                    else R.drawable.ic_baseline_favorite_24
                ),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = "Like",
                modifier = Modifier
                    .clickable { isFavorite = !isFavorite }
                    .constrainAs(icon) {
                        end.linkTo(image.end, margin = 16.dp)
                        top.linkTo(image.top, margin = 16.dp)
                    }
            )
            Text(
                text = "Пицца Маргарита",
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(image.bottom, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        width = Dimension.fillToConstraints
                    },
                style = MaterialTheme.typography.button,
            )
            Text(
                text = "Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt " +
                        "ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud " +
                        "exercitation ullamco laboris nisi ut aliquip " +
                        "ex ea commodo consequat. ",
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(title.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                        width = Dimension.fillToConstraints
                    },
                style = MaterialTheme.typography.caption,
            )
            Text(
                text = "780 ₽",
                textDecoration = TextDecoration.LineThrough,
                modifier = Modifier
                    .constrainAs(oldPrice) {
                        top.linkTo(text.bottom, margin = 24.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    },
                style = TextStyle(
                    color = MaterialTheme.colors.onPrimary,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontSize = 24.sp
                )
            )
            Text(
                text = "680 ₽",
                modifier = Modifier
                    .constrainAs(newPrice) {
                        top.linkTo(text.bottom, margin = 24.dp)
                        start.linkTo(oldPrice.end, margin = 8.dp)
                    },
                style = TextStyle(
                    color = MaterialTheme.colors.secondary,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 24.sp
                )
            )
            Box(
                modifier = Modifier
                    .height(44.dp)
                    .border(
                        border = BorderStroke(0.5.dp, MaterialTheme.colors.onPrimary),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .constrainAs(box) {
                        top.linkTo(text.bottom, margin = 16.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                    }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "-",
                        modifier = Modifier
                            .clickable { if (counter != 0) counter-- }
                            .padding(horizontal = 8.dp),
                        style = TextStyle(
                            color = MaterialTheme.colors.secondary,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontSize = 24.sp
                        )
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "$counter",
                        style = TextStyle(
                            color = MaterialTheme.colors.secondary,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontSize = 24.sp
                        )
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = "+",
                        modifier = Modifier
                            .clickable { counter++ }
                            .padding(horizontal = 8.dp),
                        style = TextStyle(
                            color = MaterialTheme.colors.secondary,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontSize = 24.sp
                        )
                    )
                }
            }
            ButtonItem(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .constrainAs(button) {
                        top.linkTo(box.bottom, margin = 16.dp)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                text = "Добавить в корзину",
                spacerHeight = 0
            )

            Box(
                modifier = Modifier
                    .background(color = Color(0xFF24232b))
                    .constrainAs(reviews) {
                        top.linkTo(button.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                contentAlignment = Alignment.TopStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Отзывы",
                            style = MaterialTheme.typography.h1
                        )
                        Icon(
                            modifier = Modifier
                                .height(16.dp)
                                .padding(start = 16.dp),
                            painter = painterResource(id = R.drawable.ic_baseline_star_24),
                            tint = MaterialTheme.colors.secondary,
                            contentDescription = "Rating"
                        )
                        Text(
                            text = "4.8/5",
                            style = MaterialTheme.typography.h6
                        )
                        Spacer(Modifier.weight(1f, true))
                        ButtonItem(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF33313B)),
                            text = "Добавить отзыв",
                            textStyle = TextStyle(
                                color = MaterialTheme.colors.onPrimary,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontSize = 12.sp
                            )
                        )
                    }
                    CardReview(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        user = "Екатерина, 19.03.20",
                        text = "Великолепная пицца. Мне очень понравилась! Рекомендую всем!"
                    )

                    CardReview(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        user = "Виктор, 15.03.20",
                        text = "Пицца так себе",
                        counter = 2
                    )

                    CardReview(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        user = "Анна, 13.03.20",
                        counter = 4
                    )
                }
            }
        }
    }

}
