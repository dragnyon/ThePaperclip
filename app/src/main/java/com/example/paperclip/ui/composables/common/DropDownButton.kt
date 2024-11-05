package com.example.paperclip.ui.composables.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropsDownButton(
    values: List<String>,
    selected: String,
    onSelectedChange: (String) -> Unit
) {

    var isOpen by remember { mutableStateOf(false) }
    val onClick = { isOpen = !isOpen }

    Box {
        FilledTonalButton(
            modifier = Modifier
                .height(25.dp)
                .width(100.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = { onClick() }
        ) {
            Text(selected, fontSize = 12.sp)
            Icon(
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = "arrow"
            )
        }

        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = { isOpen = false },
            offset = DpOffset(0.dp, 0.dp),
        ) {
            values.forEach { option ->
                DropdownMenuItem(onClick = {
                    onSelectedChange(option)
                    isOpen = false
                }, text = {
                    Text(text = option)
                })
            }
        }
    }
}