package ru.churkin.sbdelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.churkin.sbdelivery.items.CardProduct
import ru.churkin.sbdelivery.ui.DishScreen
import ru.churkin.sbdelivery.ui.EntryScreen
import ru.churkin.sbdelivery.ui.theme.AppTheme


class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                DishScreen()
            }
        }
    }
}


