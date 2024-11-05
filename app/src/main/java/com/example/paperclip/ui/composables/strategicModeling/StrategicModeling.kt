package com.example.paperclip.ui.composables.strategicModeling

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paperclip.R
import com.example.paperclip.ui.composables.common.DropsDownButton

@Composable
fun StrategicModeling() {

    val models = listOf("Pick a Strat", "RANDOM")
    var selectedModel by remember { mutableStateOf(models.first()) }

    val yomi by remember { mutableIntStateOf(0) }

    Column(
        Modifier
            .border(1.dp, Color.Black)
            .padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Strategic Modeling", fontWeight = FontWeight.Bold, fontSize = 16.sp)

            DropsDownButton(
                values = models,
                selected = selectedModel,
                onSelectedChange = { selectedModel = it }
            )

            FilledTonalButton(
                modifier = Modifier
                    .height(25.dp)
                    .width(50.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = { }
            ) { Text("Run") }
        }
        Icon(painter = painterResource(id = R.drawable.casino), "")

        Text("Pick strategy, run tournament, gain yomi")
        Text("Yomi: $yomi")
    }
}

@Preview(showBackground = true)
@Composable
fun StrategicModelingPreview() {
    StrategicModeling()
}