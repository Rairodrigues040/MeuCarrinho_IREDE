package com.rai.listademercado.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.listademercado.R


@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier
){
    //Arrangement -> disposição dos elementos
    //Row -> disposição é na horizontal
    //column -> disposição é na vertical
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.utensils_crossed),
            contentDescription = null,
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF111111)
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Surface(color = Color.White) {
        Header("Meu Carrinho")
    }
}