package com.david.composepractice.udemy.newsapp.uicomponents.topnews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.network.NewsManager

@Composable
fun TopNewsSearch(newsManager: NewsManager, modifier: Modifier = Modifier) {
    val localFocus = LocalFocusManager.current
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = newsManager.searchQuery.value,
            onValueChange = { newsManager.setSearchQuery(it) },
            label = { Text(text = stringResource(R.string.search)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            },
            trailingIcon = {
                IconButton(onClick = { newsManager.setSearchQuery("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(R.string.search)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                localFocus.clearFocus(true)
                newsManager.getArticlesByFiltering(query = newsManager.searchQuery.value)
            }),
            colors = TextFieldDefaults.textFieldColors(textColor = White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsSearchPreview() {
    TopNewsSearch(NewsManager())
}