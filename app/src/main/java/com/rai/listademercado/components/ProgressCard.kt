package com.rai.listademercado.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.listademercado.ui.theme.BrownHighLight
import com.rai.listademercado.ui.theme.BrownPrimary
import com.rai.listademercado.ui.theme.BrownSecondary
import com.rai.listademercado.ui.theme.GreenPrimary

@Composable
fun ProgressCard(
    checkedItems: Int,
    totalItems: Int,
    progress: Float,
    modifier: Modifier = Modifier
) {
//Semelhante a um quadro em branco ou uma box
    Surface(
        color = BrownHighLight,
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, BrownHighLight)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                "Progresso do carrinho",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Quase lá, ein?!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = BrownPrimary
                )
                // arredondamento nas bordas
//                RoundedCornerShape(99.dp)

                CountCapsule(text = "$checkedItems/$totalItems")
            }

            Spacer(Modifier.height(10.dp))

            LinearProgressIndicator(
                //garante que a barra não fique negativa e nem ultrapasse 100%
                //0f -> correnponde a 0 e 1f -> corrresponde a 100%
                { progress.coerceIn(0f, 1f) },
                modifier = modifier
                    .fillMaxWidth()
                    .height(18.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .border(1.dp, color = BrownSecondary, shape = RoundedCornerShape(100.dp)),
                color = GreenPrimary,
                //trackColor é a cor da “trilha” ou “fundo” de componentes
                // que possuem uma parte ativa e uma parte inativa
                trackColor = Color.White
            )
        }
    }
}

@Composable
fun CountCapsule(
    text: String,
    modifier: Modifier = Modifier
    ){
    Surface(
        color = Color.White,
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(100.dp))
            .border(2.dp, BrownSecondary, shape = RoundedCornerShape(100.dp)),
        shape = RoundedCornerShape(size = 100.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = BrownPrimary,
            fontSize = 14.sp,
            modifier = Modifier.padding(10.dp)
        )
    }

}


@Preview
@Composable
private fun ProgressCardPreview() {
    ProgressCard(checkedItems = 2, totalItems = 5, progress = 0.6f)
}