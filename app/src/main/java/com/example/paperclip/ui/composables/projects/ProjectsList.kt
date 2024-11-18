package com.example.paperclip.ui.composables.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.paperclip.data.projects
import com.example.paperclip.domain.models.Project
import com.example.paperclip.ui.theme.PaperClipTheme


@Composable
fun ProjectsList(projects: List<Project>) {

    Column {
        Text("Projects", fontWeight = FontWeight.Bold)
        HorizontalDivider(Modifier.padding(0.dp, 3.dp), 2f.dp, color = Color.Black)

        projects.forEach { project ->
            Column {
                ProjectButton(project, project.id == 2)
            }
            HorizontalDivider(Modifier.padding(0.dp, 8.dp), 0f.dp, Color.Transparent)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectsPreview() {

    PaperClipTheme {
        ProjectsList(projects.take(3))
    }
}