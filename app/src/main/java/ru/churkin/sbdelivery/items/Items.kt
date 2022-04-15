package ru.churkin.sbdelivery.items

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.Coil
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import ru.churkin.sbdelivery.Product
import ru.churkin.sbdelivery.R
import ru.churkin.sbdelivery.ui.theme.AppTheme

@Composable
fun EntryToolBar(
    text: String = "",
    actions: List<ToolBarAction> = emptyList(),
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

data class ToolBarAction(
    val icon: Int,
    val action: () -> Unit,
    val tint: Color
)

@Composable
fun BlockTextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    spacerHeight: Int = 16,
    inputType: KeyboardType = KeyboardType.Text,

    ) {
    val colors = TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.colors.onSurface,
        backgroundColor = MaterialTheme.colors.surface,
        focusedIndicatorColor = MaterialTheme.colors.secondary,
        cursorColor = MaterialTheme.colors.onSurface
    )

    var isShowPassword by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = title,
            style = titleStyle
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            trailingIcon = {
                if (inputType == KeyboardType.Password) {
                    IconButton(onClick = {
                        isShowPassword = !isShowPassword
                    }) {
                        Icon(
                            painter = painterResource(id = if (!isShowPassword) R.drawable.ic_baseline_visibility_off_24 else R.drawable.ic_baseline_visibility_24),
                            contentDescription = "Show"
                        )
                    }
                }
            },
            shape = RoundedCornerShape(8.dp),
            textStyle = MaterialTheme.typography.body1,
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            visualTransformation = if (inputType == KeyboardType.Password && !isShowPassword) PasswordVisualTransformation()
            else VisualTransformation.None,
            colors = colors
        )
        Spacer(modifier = Modifier.height(spacerHeight.dp))
    }
}

@Composable
fun ButtonItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
    text: String = "",
    textStyle: TextStyle = MaterialTheme.typography.h1,
    spacerHeight: Int = 16
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
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
) {
    TextButton(
        onClick = { onClick() },
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

@Composable
fun CardReview(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF33313C),
    user: String = "",
    text: String = "",
    counter: Int = 5
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = user,
                    style = MaterialTheme.typography.h5
                )
                Spacer(Modifier.weight(1f, true))
                var n = 1
                while (n <= counter) {
                    Icon(
                        modifier = Modifier
                            .height(16.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_star_24),
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = "Rating"
                    )
                    n++
                }
            }
            Text(
                text = text,
                style = TextStyle(
                    color = MaterialTheme.colors.onPrimary,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontSize = 12.sp
                )
            )
        }
    }
}

@Composable
fun CardProduct(
    product: Product,
    onClick: (String) -> Unit
) {
    var isFavorite: Boolean by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .defaultMinSize(minHeight = 220.dp, minWidth = 160.dp ),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val (image, icon, button, price, title) = createRefs()

            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .placeholder(R.drawable.emptyimage)
                    .error(R.drawable.emptyimage)
                    .build()
            )

            Image(
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "background",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .aspectRatio(1f)
            )
            Icon(
                painter = painterResource(
                    id = if (!isFavorite) R.drawable.ic_baseline_favorite_border_24
                    else R.drawable.ic_baseline_favorite_24
                ),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = "Like",
                modifier = Modifier
                    .alpha(0.7f)
                    .clickable { isFavorite = !isFavorite }
                    .constrainAs(icon) {
                        end.linkTo(parent.end, margin = 8.dp)
                        top.linkTo(image.top, margin = 8.dp)
                    }
            )
            FloatingActionButton(
                onClick = {
                    onClick(product.id)
                },
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .constrainAs(button) {
                        end.linkTo(parent.end, margin = 8.dp)
                        bottom.linkTo(image.bottom)
                        centerAround(image.bottom)
                    },
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "Добавить"
                )
            }
            Text(
                text = "${ product.price } ₽",
                modifier = Modifier
                    .constrainAs(price) {
                        start.linkTo(parent.start, margin = 8.dp)
                        top.linkTo(image.bottom, margin = 8.dp)
                    },
                style = MaterialTheme.typography.h6
            )
            Text(
                text = product.name,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(parent.start, margin = 8.dp)
                        top.linkTo(price.bottom, margin = 4.dp)
                    },
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun BasketRow(
    product: Product
){
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(product.image)
            .placeholder(R.drawable.emptyimage)
            .error(R.drawable.emptyimage)
            .build()
    )
    var counter: Int by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(color = MaterialTheme.colors.background)
            .defaultMinSize(minHeight = 80.dp)
    ){
        ConstraintLayout() {
            val (image, title, price, box) = createRefs()

            Image(
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "background",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .aspectRatio(1f)
            )

            Text(
                text = product.name,
                modifier = Modifier
                    .constrainAs(title) {
                        start.linkTo(image.end, margin = 16.dp)
                        top.linkTo(parent.top)
                    },
                style = MaterialTheme.typography.h1
            )

            Box(
                modifier = Modifier
                    .height(44.dp)
                    .border(
                        border = BorderStroke(0.5.dp, MaterialTheme.colors.onPrimary),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .constrainAs(box) {
                        start.linkTo(image.end, margin = 16.dp)
                        bottom.linkTo(parent.bottom)
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

            Text(
                text = "${product.price} ₽",
                modifier = Modifier
                    .constrainAs(price) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                    },
                style = TextStyle(
                    color = MaterialTheme.colors.secondary,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 18.sp
                )
            )

        }
    }

}

/*@Composable
@Preview
fun PreviewProductCard() {
    AppTheme {
        CardProduct(
            onClick = {},
            productPrice = "680 P",
            productTitle = "Пеперони",
            productImage = rememberAsyncImagePainter("https://www.delivery-club.ru/media/cms/relation_product/32350/312372888_m650.jpg")
        )
    }
}*/

