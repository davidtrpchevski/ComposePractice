package com.david.composepractice.udemy.newsapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.david.composepractice.udemy.newsapp.screens.DetailsScreen
import com.david.composepractice.udemy.newsapp.screens.TopNews

@Composable
fun NewsApp() {
    val newsNavController = rememberNavController()
    NavHost(navController = newsNavController, startDestination = "TopNews") {
        composable("TopNews") {
            TopNews(navController = newsNavController)
        }
        composable("DetailsScreen") {
            DetailsScreen(navController = newsNavController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}