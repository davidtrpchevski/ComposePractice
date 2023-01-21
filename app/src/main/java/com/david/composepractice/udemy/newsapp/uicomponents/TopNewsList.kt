package com.david.composepractice.udemy.newsapp.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel

@Composable
fun TopNewsList(
    topNewsArticles: List<TopNewsArticleModel?>?,
    onItemClicked: (TopNewsArticleModel) -> Unit,
) {
    LazyColumn {
        topNewsArticles?.let { articleList ->
            items(articleList) { item: TopNewsArticleModel? ->
                item?.let {
                    TopNewsItem(newsDataModel = it, onItemClicked = onItemClicked)
                }
            }
        }

    }
}

@Composable
fun TopNewsItem(
    newsDataModel: TopNewsArticleModel,
    modifier: Modifier = Modifier,
    onItemClicked: (TopNewsArticleModel) -> Unit
) {
    Box(modifier = modifier
        .height(200.dp)
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onItemClicked(newsDataModel) }) {
        AsyncImage(
            model = newsDataModel.urlToImage,
            contentDescription = newsDataModel.title,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .blur(6.dp)
        )
        Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = newsDataModel.publishedAt ?: stringResource(R.string.item_not_available),
                    color = Color.White,
                    modifier = modifier.padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = newsDataModel.author ?: stringResource(R.string.item_not_available),
                    color = Color.White,
                    modifier = modifier.padding(end = 8.dp, top = 8.dp)
                )
            }
            Column(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = newsDataModel.title ?: stringResource(R.string.item_not_available),
                    color = Color.White,
                    modifier = modifier.padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = newsDataModel.description ?: stringResource(R.string.item_not_available),
                    maxLines = 2,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    modifier = modifier.padding(8.dp)
                )
            }
        }
    }
}