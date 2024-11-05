package com.example.paperclip.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Paperclips(
    modifier: Modifier,
    nbPaperclips: Int = 0,
    onClickMakePaperclips: () -> Unit = {},
) {
    Column(modifier = modifier) {

        Text(
            text = "Paperclips: $nbPaperclips"
        )

        FilledTonalButton(onClick = onClickMakePaperclips) {
            Text("Make Paperclips")
        }
    }
}