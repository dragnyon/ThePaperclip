package com.example.paperclip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.paperclip.ui.theme.PaperClipTheme
import com.example.paperclip.ui.views.Stage1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaperClipTheme {
                Stage1()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PaperClipTheme {

    }
}