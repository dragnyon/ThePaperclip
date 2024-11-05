package fr.dlecol.paperclips.Investments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CashManager() {
    val cash by remember { mutableDoubleStateOf(0.0) }
    val stocks by remember { mutableDoubleStateOf(0.0) }
    val total by remember { mutableDoubleStateOf(cash + stocks) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            FilledTonalButton(
                modifier = Modifier
                    .height(25.dp)
                    .width(60.dp),

                contentPadding = PaddingValues(2.dp),
                onClick = { }
            ) {
                Text("Deposit", fontSize = 12.sp)
            }

            FilledTonalButton(
                modifier = Modifier
                    .height(25.dp)
                    .width(60.dp),

                contentPadding = PaddingValues(0.dp),
                onClick = { }
            ) {
                Text("Withdraw", fontSize = 12.sp)
            }
        }
        Column {
            Text("Cash: \$$cash")
            Text("Stocks: \$$stocks")
            Text("Total: \$$total", fontWeight = FontWeight.Bold)
        }
    }
}