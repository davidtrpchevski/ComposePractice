package com.david.composepractice.udemy.newsapp.uicomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel

@Composable
fun CategoryList(categoriesList: List<TopNewsArticleModel?>?) {
    LazyColumn {
        categoriesList?.let {
            items(it) { categoryItem ->
                CategoryListItem(topNewsArticleModel = categoryItem)
            }
        }
    }
}

@Composable
fun CategoryListItem(topNewsArticleModel: TopNewsArticleModel?, modifier: Modifier = Modifier) {
    topNewsArticleModel?.let {
        Card(
            shape = RoundedCornerShape(2.dp),
            border = BorderStroke(2.dp, Color.DarkGray),
            modifier = modifier.padding(8.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = it.urlToImage,
                    contentDescription = it.title,
                    modifier = modifier.size(100.dp)
                )
                Column(modifier.padding(8.dp)) {
                    Text(
                        text = it.title ?: stringResource(R.string.item_not_available),
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = it.author
                                ?: stringResource(R.string.item_not_available)
                        )
                        Text(
                            text = it.publishedAt
                                ?: stringResource(R.string.item_not_available)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListItemPreview() {
    CategoryListItem(
        TopNewsArticleModel(
            "David",
            "DAVID",
            "DAVID",
            "DAVID",
            null,
            "DAVID",
            "SOMEURL",
            "https://i.imgur.com/GgELcaV.jpeg"
        )
    )
}