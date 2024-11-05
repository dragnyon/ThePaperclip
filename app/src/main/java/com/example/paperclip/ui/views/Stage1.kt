package com.example.paperclip.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

    Column(Modifier.verticalScroll(rememberScrollState())) {
        Paperclips(
            nbPaperclips = paperclips,
            onClickMakePaperclips = { paperclips++ }
        )
        Business()
        Manufacturing()

        ComputationalResources()
        ProjectsList(
            projects.take(3)
        )

        Investments(

        )
    }
}


