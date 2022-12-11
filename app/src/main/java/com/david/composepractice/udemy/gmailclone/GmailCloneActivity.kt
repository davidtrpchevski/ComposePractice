package com.david.composepractice.udemy.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.david.composepractice.udemy.gmailclone.components.HomeAppBar
import com.david.composepractice.ui.theme.ComposePracticeTheme

class GmailCloneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                GmailClone()
            }
        }
    }
}

@Composable
fun GmailClone() {
    Scaffold(topBar = { HomeAppBar() }) {
        it
    }
}

@Preview
@Composable
fun GmailClonePreview() {
    ComposePracticeTheme {
        GmailClone()
    }
}