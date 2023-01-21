package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.david.composepractice.udemy.newsapp.network.NewsManager
import com.david.composepractice.udemy.newsapp.uicomponents.sources.SourcesList
import com.david.composepractice.udemy.newsapp.uicomponents.sources.SourcesTopAppBar

@Composable
fun SourcesScreen(newsManager: NewsManager) {
    var dropDownMenuState by remember { mutableStateOf(false) }

    val menuItems: List<Pair<String, String>> = listOf(
        "TechCrunch" to "techcrunch",
        "TalkSport" to "talksport",
        "Business Insider" to "business-insider",
        "Reuters" to "reuters",
        "Politico" to "politico",
        "TheVerge" to "the-verge"
    )

    Scaffold(
        topBar = {
            SourcesTopAppBar(menuItems, dropDownMenuState, newsManager, onDismissAction = {
                dropDownMenuState = false
            }, onClickAction = {
                dropDownMenuState = true
            })
        }
    ) {
        SourcesList(it)
    }
}

