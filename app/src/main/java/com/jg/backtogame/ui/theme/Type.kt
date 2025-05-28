package com.jg.backtogame.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jg.backtogame.app.R


val poppinsSemiBoldFontFamily = FontFamily(
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold)
)
val poppinsMediumFontFamily = FontFamily(
    Font(R.font.poppins_medium, weight =FontWeight.Bold)
)
val poppinsRegularFontFamily = FontFamily(
    Font(R.font.poppins_regular)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsMediumFontFamily,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsSemiBoldFontFamily,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
),
    labelSmall = TextStyle(
        fontFamily = poppinsRegularFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)




