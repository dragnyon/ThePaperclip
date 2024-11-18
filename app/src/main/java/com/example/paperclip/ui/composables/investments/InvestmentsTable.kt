package com.example.paperclip.ui.composables.investments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InvestmentsTable() {

    val headers = listOf("Stock", "Amt.", "Price", "Total", "P/L")

    val values by remember {
        mutableStateOf(
            listOf(
                listOf("", "", "", "", ""),
                listOf("", "", "", "", ""),
                listOf("", "", "", "", ""),
                listOf("", "", "", "", ""),
                listOf("", "", "", "", ""),
            )
        )
    }

    val cellModifier = Modifier
        .width(70.dp)
        .padding(0.dp, 2.dp)

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            headers.forEach { header ->
                Text(
                    header,
                    cellModifier, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        var colored = true
        values.forEach { value ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                value.forEach { stringValue ->
                    Text(
                        stringValue,
                        cellModifier.background(color = if (colored) Color.LightGray else Color.Transparent),
                        textAlign = TextAlign.Center
                    )

                }
            }
            colored = !colored
        }
    }

}