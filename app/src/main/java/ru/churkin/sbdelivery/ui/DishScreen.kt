package ru.churkin.sbdelivery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.churkin.sbdelivery.R
import ru.churkin.sbdelivery.items.EntryToolBar


@Composable
fun DishScreen() {
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
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            val (image, box, icon) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.pizza),
                contentScale = ContentScale.Fit,
                contentDescription = "background",
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(parent.top)
                }
            )
            Box(
                modifier = Modifier
                    .constrainAs(box) {
                        top.linkTo(image.top, margin = 16.dp)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.stock),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "background"
                )
                Text(
                    text = " АКЦИЯ ",
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.overline,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = "Like",
                modifier = Modifier
                    .constrainAs(icon) {
                        end.linkTo(image.end, margin = 16.dp)
                        top.linkTo(image.top, margin = 16.dp)
                    }
            )
        }
    }

}
