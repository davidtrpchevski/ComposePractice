package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.david.composepractice.udemy.newsapp.uicomponents.TopNewsList

@Composable
fun TopNews(navController: NavController) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Top News", modifier = Modifier.padding(vertical = 12.dp))
        TopNewsList {
            navController.navigate("DetailsScreen/${it.id}")
        }
        /*
        Button(onClick = { navController.navigate("DetailsScreen") }) {
            Text(text = "Navigate to DetailsScreen")
        }
        */
    }
}

@Preview
@Composable
fun TopNewsPreview() {
    TopNews(rememberNavController())
}