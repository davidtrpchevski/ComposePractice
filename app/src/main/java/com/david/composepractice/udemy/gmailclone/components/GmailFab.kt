package com.david.composepractice.udemy.gmailclone.components

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value > 50) {
        ExtendedFloatingActionButton(text = { Text(text = "Compose") },
            onClick = { Log.d("GmailFab", "New Mail") },
            icon = { Icon(imageVector = Icons.Default.Mail, contentDescription = "") })
    } else {
        FloatingActionButton(onClick = { Log.d("GmailFab", "New Mail") }) {
            Icon(imageVector = Icons.Default.Mail, contentDescription = "")
        }
    }
}
