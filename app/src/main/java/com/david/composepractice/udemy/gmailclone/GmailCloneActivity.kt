package com.david.composepractice.udemy.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.david.composepractice.udemy.gmailclone.components.GmailDrawerMenu
import com.david.composepractice.udemy.gmailclone.components.GmailFab
import com.david.composepractice.udemy.gmailclone.components.HomeAppBar
import com.david.composepractice.udemy.gmailclone.components.HomeBottomBar
import com.david.composepractice.udemy.gmailclone.components.MailList
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
    val drawerScaffoldState = rememberScaffoldState()
    val drawerCoroutineScope = rememberCoroutineScope()
    val drawerScrollState = rememberScrollState()
    val mailListScrollState = rememberScrollState()
    val dialogOpenState = remember {
        mutableStateOf(false)
    }

    Scaffold(scaffoldState = drawerScaffoldState,
        topBar = { HomeAppBar(drawerScaffoldState, drawerCoroutineScope, dialogOpenState) },
        drawerContent = { GmailDrawerMenu(drawerScrollState) },
        floatingActionButton = { GmailFab(scrollState = (mailListScrollState)) },
        bottomBar = { HomeBottomBar() }) {
        MailList(it, scrollState = mailListScrollState)
    }
}

@Preview
@Composable
fun GmailClonePreview() {
    ComposePracticeTheme {
        GmailClone()
    }
}