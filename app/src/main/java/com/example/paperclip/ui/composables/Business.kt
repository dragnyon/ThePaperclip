package com.example.paperclip.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Business(
    modifier: Modifier,
    funds: Double = 0.0,
    unsold: Int = 0,
    price: Double = 0.0,
    onClickLower: () -> Unit = {},
    onClickRaise: () -> Unit = {},
    demand: Int = 0,
    onClickMarket: () -> Unit = {},
    levelMarket: Int = 0,
    costMarket: Double = 0.0,
    avgRev: Double = 0.0,
    avgClipsSold: Int = 0
) {
    Column(modifier = modifier) {
        Text(
            text = "Business"
        )
        HorizontalDivider(thickness = 2.dp)
        Text(
            text = "Available Funds: \$ $funds"
        )
        Text(
            text = "Avg. Rev. per sec : \$ $avgRev"
        )
        Text(
            text = "Avg. Clips Sold per sec: \$ $avgClipsSold"
        )

        Text(
            text = "Unsold Inventory: $unsold"
        )

        Row {
            FilledTonalButton(onClick = onClickLower) {
                Text("Lower")
            }
            FilledTonalButton(onClick = onClickRaise) {
                Text("Raise")
            }
            Text(
                text = "Price per Clip: \$ $price"
            )
        }
        Text(
            text = "Public Demand: $demand %"
        )
        Row {
            FilledTonalButton(onClick = onClickMarket) {
                Text("Marketing")
            }
            Text(
                text = "Level : $levelMarket"
            )
        }

        Text(
            text = "Cost : \$ $costMarket"
        )
    }
}