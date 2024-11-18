package com.example.paperclip.ui.composables.paperclips

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.math.BigInteger

@Composable
fun Paperclips(
    nbPaperclips: BigInteger = BigInteger("0"),
    onClickMakePaperclips: () -> Unit = {},
) {
    Column() {

        Text(
            text = "Paperclips: $nbPaperclips"
        )

        FilledTonalButton(onClick = onClickMakePaperclips) {
            Text("Make Paperclips")
        }
    }
}