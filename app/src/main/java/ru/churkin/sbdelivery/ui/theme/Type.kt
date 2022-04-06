package ru.churkin.sbdelivery.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.churkin.sbdelivery.R

val robotoMedium = FontFamily(Font(R.font.roboto_medium))
val robotoRegular = FontFamily(Font(R.font.roboto_regular))
val robotoLight = FontFamily(Font(R.font.roboto_light))


    fun MyTypography() = Typography(
        h1 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 18.sp,
            color = onPrimary
        ),
        h2 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 18.sp,
            color = onBackground
        ),
        h3 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 16.sp,
            color = secondary
        ),
        h4 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 16.sp,
            color = onPrimary
        ),
        h5 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 14.sp,
            color = onPrimary
        ),
        h6 = TextStyle(
            fontFamily = robotoMedium,
            fontSize = 14.sp,
            color = secondary
        ),
        subtitle1 = TextStyle(
            fontFamily = robotoRegular,
            fontSize = 12.sp,
            color = onBackground
        ),
        subtitle2 = TextStyle(
            fontFamily = robotoRegular,
            fontSize = 12.sp,
            color = error
        ),
        body1 = TextStyle(
            fontFamily = robotoRegular,
            fontSize = 14.sp,
            color = onSurface
        ),
        body2 = TextStyle(
            fontFamily = robotoLight,
            fontSize = 14.sp,
            color = onBackground
        ),
        caption = TextStyle(
            fontFamily = robotoLight,
            fontSize = 13.sp,
            color = onBackground
        )
    )
