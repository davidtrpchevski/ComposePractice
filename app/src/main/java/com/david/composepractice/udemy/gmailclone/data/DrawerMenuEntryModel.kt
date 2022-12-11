package com.david.composepractice.udemy.gmailclone.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.NetworkWifi
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenuEntryModel(
    val icon: ImageVector? = null,
    val title: String? = null,
    val isHeader: Boolean = false,
    val isDivider: Boolean = false,
) {
    companion object {
        fun getDrawerMenuItems() = listOf(DrawerMenuEntryModel(isDivider = true),
            DrawerMenuEntryModel(icon = Icons.Outlined.AllInbox, title = "All Inbox"),
            DrawerMenuEntryModel(isDivider = true),
            DrawerMenuEntryModel(icon = Icons.Outlined.Inbox, title = "Inbox"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Person, title = "Account"),
            DrawerMenuEntryModel(icon = Icons.Outlined.NetworkWifi, title = "Social"),
            DrawerMenuEntryModel(isHeader = true, title = "ALL LABELS"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Inbox, title = "Inbox"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Person, title = "Account"),
            DrawerMenuEntryModel(icon = Icons.Outlined.NetworkWifi, title = "Social"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Inbox, title = "Inbox"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Person, title = "Account"),
            DrawerMenuEntryModel(icon = Icons.Outlined.NetworkWifi, title = "Social"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Inbox, title = "Inbox"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Person, title = "Account"),
            DrawerMenuEntryModel(icon = Icons.Outlined.NetworkWifi, title = "Social"),
            DrawerMenuEntryModel(isHeader = true, title = "GOOGLE APPS"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Inbox, title = "Inbox"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Person, title = "Account"),
            DrawerMenuEntryModel(icon = Icons.Outlined.NetworkWifi, title = "Social"),
            DrawerMenuEntryModel(isDivider = true),
            DrawerMenuEntryModel(icon = Icons.Outlined.Settings, title = "Settings"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Feedback, title = "Feedback"),
            DrawerMenuEntryModel(icon = Icons.Outlined.Help, title = "Help"))
    }
}