package com.example.paperclip.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.paperclip.ui.composables.Business
import com.example.paperclip.ui.composables.ComputationalResources
import com.example.paperclip.ui.composables.Manufacturing
import com.example.paperclip.ui.composables.Paperclips
import com.example.paperclip.ui.composables.ProjectsList
import fr.dlecol.paperclips.Investments.Investments


@Composable
fun Stage1(

) {
    var paperclips by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()

    ) { innerPadding ->

        Column(Modifier.verticalScroll(rememberScrollState())) {
            Paperclips(
                modifier = Modifier.padding(innerPadding),
                nbPaperclips = paperclips,
                onClickMakePaperclips = { paperclips++ }
            )
            Business(
                modifier = Modifier.padding(innerPadding)

            )
            Manufacturing(
                modifier = Modifier.padding(innerPadding)
            )

            ComputationalResources(
                modifier = Modifier.padding(innerPadding)

            )
            ProjectsList(
                projects.take(3)
            )

            Investments(

            )


        }
    }
}


