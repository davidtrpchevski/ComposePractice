package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.NewsDataModel

@Composable
fun DetailsScreen(navController: NavController, newsDataModel: NewsDataModel) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Details Screen")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Navigate to topNews")
        }
        Text(text = newsDataModel.title)
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
        )
    )
}