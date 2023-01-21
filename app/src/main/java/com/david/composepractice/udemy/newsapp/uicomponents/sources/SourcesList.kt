package com.david.composepractice.udemy.newsapp.uicomponents.sources

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SourcesList(paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(paddingValues)) {

    }
}