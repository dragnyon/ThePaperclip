package fr.dlecol.paperclips.Investments

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Investments() {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Box(Modifier.border(1.dp, Color.Black)) {
            Column {
                Row(
                    Modifier.padding(8.dp, 0.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Investments", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    RiskButton()
                }
                HorizontalDivider(Modifier.padding(0.dp, 5.dp), 1.dp, Color.Transparent)
                CashManager()
                HorizontalDivider(Modifier.padding(0.dp, 5.dp), 1.dp, Color.Transparent)
                InvestmentsTable()
                HorizontalDivider(Modifier.padding(0.dp, 5.dp), 1.dp, Color.Transparent)
            }
        }
        UpgradeManager()
    }
}

@Preview(showBackground = true)
@Composable
fun InvestmentsPreview() {
    Investments()
}