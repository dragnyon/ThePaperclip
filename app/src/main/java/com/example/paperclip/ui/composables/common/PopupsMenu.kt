package com.example.paperclip.ui.composables.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paperclip.R
import com.example.paperclip.ui.composables.ComputationalResources
import com.example.paperclip.ui.composables.ProjectsList
import com.example.paperclip.ui.composables.strategicModeling.StrategicModeling
import com.example.paperclip.ui.views.projects

@Composable
fun PopupsMenu() {
    var visible by remember { mutableStateOf(false) }
    var visible2 by remember { mutableStateOf(false) }
    var visible3 by remember { mutableStateOf(false) }
    var visible4 by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.90f),
            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.End
        ) {
            PopupContainer(visible = visible) {
                ProjectsList(projects.take(3))
            }

            PopupContainer(visible = visible2) {
                ComputationalResources()
            }

            PopupContainer(visible = visible3) {
                ComputationalResources()
            }

            PopupContainer(visible = visible4) {
                StrategicModeling()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.10f),
            verticalArrangement = Arrangement.Center
        ) {

            SmallFloatingActionButton(
                onClick = { visible = !visible },
                shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.AutoMirrored.Rounded.List, "Small floating action button.")
            }

            SmallFloatingActionButton(
                onClick = { visible2 = !visible2 },
                shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(painter = painterResource(id = R.drawable.memory), "")
            }

            SmallFloatingActionButton(
                onClick = { visible3 = !visible3 },
                shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(painter = painterResource(id = R.drawable.stocks), "")
            }

            SmallFloatingActionButton(
                onClick = { visible4 = !visible4 },
                shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(painter = painterResource(id = R.drawable.strategy), "")
            }
        }
    }
}