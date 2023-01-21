package com.david.composepractice.udemy.newsapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Source
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationDestination(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object TopNews :
        BottomNavigationDestination(route = "TopNews", icon = Icons.Outlined.Home, "Home")

    object Categories : BottomNavigationDestination(
        route = "Categories",
        icon = Icons.Outlined.Category,
        "Categories"
    )

    object Sources :
        BottomNavigationDestination(route = "Sources", icon = Icons.Outlined.Source, "Sources")
}
