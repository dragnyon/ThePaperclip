package com.example.paperclip.ui.composables.manufacturing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import java.math.BigDecimal
import java.math.BigInteger

@Composable
fun Manufacturing(
    funds: Double = 0.00,
    clipsPerSecond: Int = 0,
    wires: BigInteger = BigInteger("0"),
    onClickWire: () -> Unit = {},
    costWire: Int = 0,
    onClickMegaClippers: () -> Unit = {},
    nbMegaClippers: Int = 0,
    costMegaClippers: Double = 0.0,
    onClickAutoClippers: () -> Unit = {},
    nbAutoClippers: Int = 0,
    costAutoClippers: Double = 0.0,
    onClickWireBuyer: () -> Unit = {},
    stateWireBuyer: Boolean = false,
) {
    Column() {
        Text(
            text = "Manufacturing"
        )

        HorizontalDivider(thickness = 2.dp)

        Text(
            text = "Clips per Second : $clipsPerSecond"
        )
        Row {
            FilledTonalButton(onClick = onClickWireBuyer, enabled = false) {
                Text("WireBuyer")
            }
            Text(
                if (stateWireBuyer) "ON" else "OFF"

            )
        }
        Row {
            FilledTonalButton(onClick = onClickWire, enabled = funds >= costWire) {
                Text("Wire")
            }
            Text(
                text = "$wires inches"
            )
        }

        Text(
            text = "Cost : \$ $costWire"
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            FilledTonalButton(onClick = onClickAutoClippers, enabled = funds >= costAutoClippers) {
                Text("AutoClippers")
            }

            Text(
                text = "$nbAutoClippers"
            )
        }

        Text(
            text = "Cost : \$ $costAutoClippers"
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            FilledTonalButton(onClick = onClickMegaClippers, enabled = false) {
                Text("MegaClippers")
            }

            Text(
                text = "$nbMegaClippers"
            )
        }

        Text(
            text = "Cost : \$ $costMegaClippers"
        )
    }
}