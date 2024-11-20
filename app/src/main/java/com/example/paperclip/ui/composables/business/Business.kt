package com.example.paperclip.ui.composables.business

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.math.BigDecimal
import java.math.BigInteger

@Composable
fun Business(
    funds: BigDecimal = BigDecimal("0.00"),
    unsold: BigInteger = BigInteger("0"),
    price: BigDecimal = BigDecimal("0.00"),
    onClickLower: () -> Unit = {},
    onClickRaise: () -> Unit = {},
    demand: Int = 0,
    onClickMarket: () -> Unit = {},
    levelMarket: Int = 0,
    costMarket: Double = 0.0,
    avgRev: Double = 0.0,
    avgClipsSold: Int = 0
) {
    Column() {
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

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledTonalButton(
                modifier = Modifier
                    .height(25.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = onClickLower
            ) {
                Text("Lower")
            }
            FilledTonalButton(
                modifier = Modifier
                    .height(25.dp),
                contentPadding = PaddingValues(0.dp),
                onClick = onClickRaise
            ) {
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
            FilledTonalButton(onClick = onClickMarket, enabled = funds >= costMarket.toBigDecimal()) {
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