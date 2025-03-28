package com.example.paperclip.ui.composables.compute

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ComputationalResources(
    nbTrust: Int = 0,
    checkpointTrust: Int = 0,
    levelProcessor: Int = 0,
    levelMemory: Int = 0,
    maxOperation: Int = 0,
    currentOperation: Int = 0,
    creativity: Int = 0,
    onClickAddProcessor: () -> Unit = {},
    onClickAddMemory: () -> Unit = {},
) {
    Column() {
        Text(
            text = "Trust : \$ $nbTrust"
        )
        Text(
            text = "+1 Trust at : \$ $checkpointTrust"
        )
        Row {
            FilledTonalButton(onClick = onClickAddProcessor) {
                Text("Processor")
            }

            Text(
                text = "$levelProcessor"
            )
        }
        Row {
            FilledTonalButton(onClick = onClickAddMemory) {
                Text("Memory")
            }

            Text(
                text = "$levelMemory"
            )
        }

        Text(
            text = "Operations : $currentOperation / $maxOperation"
        )

        Text(
            text = "Creativity: $creativity"
        )
    }
}