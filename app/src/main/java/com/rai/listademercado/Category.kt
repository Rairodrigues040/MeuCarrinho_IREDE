package com.rai.listademercado

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.rai.listademercado.ui.theme.BlueHighLight
import com.rai.listademercado.ui.theme.BluePrimary
import com.rai.listademercado.ui.theme.BlueSecondary
import com.rai.listademercado.ui.theme.BrownHighLight
import com.rai.listademercado.ui.theme.BrownPrimary
import com.rai.listademercado.ui.theme.BrownSecondary
import com.rai.listademercado.ui.theme.GreenHighLight
import com.rai.listademercado.ui.theme.GreenPrimary
import com.rai.listademercado.ui.theme.GreenSecondary
import com.rai.listademercado.ui.theme.OrangeHighLight
import com.rai.listademercado.ui.theme.OrangePrimary
import com.rai.listademercado.ui.theme.OrangeSecondary
import com.rai.listademercado.ui.theme.PurpleHighLight
import com.rai.listademercado.ui.theme.PurplePrimary
import com.rai.listademercado.ui.theme.PurpleSecondary
import com.rai.listademercado.ui.theme.RedHighLight
import com.rai.listademercado.ui.theme.RedPrimary
import com.rai.listademercado.ui.theme.RedSecondary

enum class Category (
    val title: String,
    val mainColor: Color,
    val backgroudColor: Color,
    val borderColor: Color,
    val iconRes: Int
    ) {

    FRUITS(
        title = "Frutas e Vegetais",
        mainColor = GreenPrimary,
        backgroudColor = GreenHighLight,
        borderColor = GreenSecondary,
        iconRes = R.drawable.lucide_leaf
    ),

    Dairy(
        title = "Laticínios e Ovos",
        mainColor = OrangePrimary,
        backgroudColor = OrangeHighLight,
        borderColor = OrangeSecondary,
        iconRes = R.drawable.lucide_egg
    ),

    CLEANING(
        title = "Itens de Limpeza",
        mainColor = BluePrimary,
        backgroudColor = BlueHighLight,
        borderColor = BlueSecondary,
        iconRes = R.drawable.lucide_bubbles
    ),

    BAKERY(
        title = "Padaria",
        mainColor = BrownPrimary,
        backgroudColor = BrownHighLight,
        borderColor = BrownSecondary,
        iconRes = R.drawable.lucide_croissant
    ),

    MEAT(
        title = "Carnes",
        mainColor = RedPrimary,
        backgroudColor = RedHighLight,
        borderColor = RedSecondary,
        iconRes = R.drawable.lucide_beef
    ),

    SNACKS(
        title = "Lanches",
        mainColor = PurplePrimary,
        backgroudColor = PurpleHighLight,
        borderColor = PurpleSecondary,
        iconRes = R.drawable.lucide_donut
    )



}