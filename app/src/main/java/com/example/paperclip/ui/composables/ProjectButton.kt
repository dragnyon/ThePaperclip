package com.example.paperclip.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.paperclip.ui.theme.PaperClipTheme
import com.example.paperclip.ui.views.Project

@Composable
fun ProjectButton(project: Project, selectable: Boolean = false) {

    val fontColor = if (selectable) Color.Black else Color.Gray
    var boxModifier = Modifier
        .background(Color.LightGray)
        .height(100.dp)

    if (selectable) {
        boxModifier = boxModifier.border(1.dp, Color.Black)
    }

    Box(boxModifier) {
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(project.title, fontWeight = FontWeight.Bold, color = fontColor)
                Text(project.priceTag, color = fontColor)
            }
            Text(
                project.description,
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp),
                textAlign = TextAlign.Center,
                color = fontColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectButtonPreview() {

    PaperClipTheme {
        ProjectButton(Project(1, "Project 1", " (1000€) ", "Description of project 1"))

    }
}

@Preview(showBackground = true)
@Composable
fun ProjectButtonSelectablePreview() {

    PaperClipTheme {
        ProjectButton(Project(1, "Project 1", " (1000€) ", "Description of project 1"), true)

    }
}