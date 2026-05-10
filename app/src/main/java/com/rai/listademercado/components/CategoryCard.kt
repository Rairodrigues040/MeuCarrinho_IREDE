package com.rai.listademercado.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rai.listademercado.Category

@Composable
fun CategoryCard(
    category: Category,
    expanded: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier,
//    content: @Composable () -> Unit
){
    val shape = RoundedCornerShape(25.dp)
    Surface(
        shape = shape,
        color = category.backgroudColor,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, category.mainColor)
            .clip(shape)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) { }
        }
    }
}

@Preview
@Composable
fun PreviewCategoryCard() {
    CategoryCard(
        category = Category.FRUITS,
        expanded = false,
        onToggle = {},
    )
}