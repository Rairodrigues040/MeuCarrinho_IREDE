package com.rai.listademercado.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.listademercado.Item


@Composable
fun ItemPill(
    item: Item,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
){
    val shape = RoundedCornerShape(100.dp)

    Surface(
        shape = shape,
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, item.category.borderColor)
            .clickable{ onToggle() }
    ) {
        Row(
            modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

        CircleCheck(
            checked = item.checked,
            onToggle = onToggle,
            main = item.category.mainColor
        )

            Spacer(Modifier.width(10.dp))

            val textColor = if (item.checked) Color(0xFFA9A9A9) else Color(0xFF4E4E4E)
            val deco = if (item.checked) TextDecoration.LineThrough else TextDecoration.None

            Text(
                text = "${item.quantityText} ${item.name}",
                color = textColor,
                textDecoration = deco,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Colocar em um componente separado depois

@Composable
fun CircleCheck(
    checked: Boolean,
    onToggle: () -> Unit,
    main: Color,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(22.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = if (checked) main else main,
                shape = CircleShape
            )
            .background(if (checked) main else Color.Transparent)
            .clickable{onToggle()},
        contentAlignment = Alignment.Center
    ){
        if(checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}













