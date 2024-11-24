package com.example.paperclip.ui.composables.paperclips

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.paperclip.ui.animation.animateNumberAsState
import java.math.BigInteger

@Composable
fun Paperclips(
    nbPaperclips: BigInteger = BigInteger("0"),
    onClickMakePaperclips: () -> Unit = {},
) {

    val animatePaperclip = animateNumberAsState(nbPaperclips, 1000)
    Column {

        Text(
            text = "Paperclips: $animatePaperclip"
        )

        FilledTonalButton(onClick = onClickMakePaperclips) {
            Text("Make Paperclips")
        }
    }
}