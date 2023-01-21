package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Details
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.NewsDataModel

@Composable
fun DetailsScreen(
    navController: NavController, newsDataModel: NewsDataModel, scrollState: ScrollState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Text(text = "Details Screen")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Navigate to topNews")
        }
        Image(
            painter = painterResource(id = newsDataModel.image),
            contentDescription = newsDataModel.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxHeight(.8f)
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            ItemRowInfo(icon = Icons.Outlined.Details, title = newsDataModel.author)
            ItemRowInfo(icon = Icons.Outlined.CalendarMonth, title = newsDataModel.publishedAt)
        }
        Text(
            text = newsDataModel.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(text = newsDataModel.description)
    }
}

@Composable
fun ItemRowInfo(icon: ImageVector, title: String) {
    Row(modifier = Modifier) {
        Icon(imageVector = icon, contentDescription = title)
        Text(text = title)
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        rememberNavController(), NewsDataModel(
            4,
            R.drawable.husky,
            author = "Mike Florio",
            title = "Aaron Rodgers violated COVID protocol by doing maskless indoor press conferences - NBC Sports",
            description = "Packers quarterback Aaron Rodgers has been conducting in-person press conferences in the Green Bay facility without wearing a mask. Because he was secretly unvaccinated, Rodgers violated the rules.",
            publishedAt = "2021-11-04T03:21:00Z"
        ), rememberScrollState()
    )
}