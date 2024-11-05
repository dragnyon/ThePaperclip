package com.example.paperclip.ui.composables.messagesBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MessageBox() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
    ) {
        Column(
            Modifier.padding(2.dp, 8.dp)
        ) {
            Text(
                text = ". Welcome to Universal Paperclips",
                color = Color.Gray
            )
            Text(
                text = ". Lifetime investment revenue report: \$0",
                color = Color.Gray
            )
            Text(
                text = ". Lifetime investment revenue report: \$0",
                color = Color.Gray
            )
            Text(
                text = ". Lifetime investment revenue report: \$0",
                color = Color.Gray
            )
            Text(
                text = "> Lifetime investment revenue report: \$0",
                color = Color.White
            )
        }
    }
}