package fr.dlecol.paperclips.Investments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpgradeManager() {
    val level by remember { mutableIntStateOf(0) }
    val cost by remember { mutableIntStateOf(0) }
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledTonalButton(
                modifier = Modifier
                    .height(20.dp),

                contentPadding = PaddingValues(2.dp, 0.dp),
                onClick = { }
            ) {
                Text("Upgrade Investment Engine", fontSize = 12.sp)
            }

            Text("Level: $level", fontSize = 12.sp)
        }
        Text("Cost: $cost Yomi", fontSize = 12.sp)
    }
}