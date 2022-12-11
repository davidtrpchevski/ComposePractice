package com.david.composepractice.udemy.gmailclone.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.david.composepractice.udemy.gmailclone.data.BottomBarEntryModel

@Composable
fun HomeBottomBar() {
    BottomNavigation(backgroundColor = Color.White,
        contentColor = Color.DarkGray,
        elevation = 2.dp) {
        BottomBarEntryModel.bottomBarEntries.forEach {
            var selected by remember {
                mutableStateOf(false)
            }
            BottomNavigationItem(selected = selected,
                alwaysShowLabel = true,
                onClick = { selected = true },
                label = { Text(text = it.title) },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) })
        }
    }
}

