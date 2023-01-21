package com.david.composepractice.udemy.newsapp.uicomponents

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.MockData
import com.david.composepractice.udemy.newsapp.model.NewsDataModel

@Composable
fun TopNewsList() {
    LazyColumn {
        items(MockData.topNewsList) { item: NewsDataModel ->
            TopNewsItem(newsDataModel = item)
        }
    }
}

@Composable
fun TopNewsItem(newsDataModel: NewsDataModel, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = newsDataModel.image),
            contentDescription = newsDataModel.title,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .blur(6.dp)
        )
        Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = newsDataModel.publishedAt,
                    color = Color.White,
                    modifier = modifier.padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = newsDataModel.author,
                    color = Color.White,
                    modifier = modifier.padding(end = 8.dp, top = 8.dp)
                )
            }
            Column(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = newsDataModel.title,
                    color = Color.White,
                    modifier = modifier.padding(start = 8.dp, top = 8.dp)
                )
                Text(
                    text = newsDataModel.description,
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

@Preview(showBackground = true)
@Composable
fun TopNewsItemPreview() {
    TopNewsItem(
        NewsDataModel(
            4,
            R.drawable.husky,
            author = "Mike Florio",
            title = "Aaron Rodgers violated COVID protocol by doing maskless indoor press conferences - NBC Sports",
            description = "Packers quarterback Aaron Rodgers has been conducting in-person press conferences in the Green Bay facility without wearing a mask. Because he was secretly unvaccinated, Rodgers violated the rules.",
            publishedAt = "2021-11-04T03:21:00Z"
        )
    )
}