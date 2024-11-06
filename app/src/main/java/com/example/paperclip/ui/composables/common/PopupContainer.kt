package com.example.paperclip.ui.composables.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun PopupContainer(
    visible: Boolean,
    content: @Composable () -> Unit
) {

    Column(

    ) {
        AnimatedVisibility(
            visible,
            enter =
            expandIn(
                // Overwrites the default spring animation with tween
                animationSpec = tween(100, easing = LinearOutSlowInEasing),
                // Overwrites the corner of the content that is first revealed
                expandFrom = Alignment.BottomStart
            ) {
                // Overwrites the initial size to 50 pixels by 50 pixels
                IntSize(50, 50)
            },
            exit =
            shrinkOut(
                tween(100, easing = FastOutSlowInEasing),
                // Overwrites the area of the content that the shrink animation will end on. The
                // following parameters will shrink the content's clip bounds from the full size of
                // the
                // content to 1/10 of the width and 1/5 of the height. The shrinking clip bounds
                // will
                // always be aligned to the CenterStart of the full-content bounds.
                shrinkTowards = Alignment.CenterStart
            ) { fullSize ->
                // Overwrites the target size of the shrinking animation.
                IntSize(fullSize.width / 10, fullSize.height / 5)
            }
        ) {
            // Content that needs to appear/disappear goes here:
            //Investments()
            Box(
                Modifier
                    .shadow(6.dp, RoundedCornerShape(15.dp))
                    .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                    .fillMaxWidth(0.95f)
            ) {
                content()
            }
        }
    }
}