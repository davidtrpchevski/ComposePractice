package com.david.composepractice.udemy.gmailclone.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarEntryModel(val icon: ImageVector, val title: String) {
    companion object {
        val bottomBarEntries =
            listOf(BottomBarEntryModel(icon = Icons.Default.Mail, title = "Mail"),
                BottomBarEntryModel(icon = Icons.Default.VideoCall, title = "Chat"))
    }
}