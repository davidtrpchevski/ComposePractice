package com.david.composepractice.udemy.newsapp.uicomponents.sources

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.david.composepractice.udemy.newsapp.network.NewsManager

@Composable
fun SourcesTopAppBar(
    menuItems: List<Pair<String, String>>,
    dropDownMenuState: Boolean,
    newsManager: NewsManager,
    onDismissAction: () -> Unit,
    onClickAction: () -> Unit
) {
    TopAppBar(title = { Text(text = "${newsManager.selectedSource.value?.first} Source") },
        actions = {
            IconButton(onClick = onClickAction) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
            }
            SourcesDropDownMenu(
                dropDownMenuState, onDismissAction, menuItems, newsManager
            )
        })
}

@Composable
private fun SourcesDropDownMenu(
    dropDownMenuState: Boolean,
    onDismissAction: () -> Unit,
    menuItems: List<Pair<String, String>>,
    newsManager: NewsManager,
) {
    MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(16.dp))) {
        DropdownMenu(expanded = dropDownMenuState, onDismissRequest = onDismissAction) {
            menuItems.forEach { menuItem ->
                DropdownMenuItem(onClick = {
                    newsManager.selectedSource.value = menuItem
                    newsManager.getArticlesBySource(newsManager.selectedSource.value?.second)
                    onDismissAction()
                }) {
                    Text(text = menuItem.first)
                }
            }
        }
    }
}
