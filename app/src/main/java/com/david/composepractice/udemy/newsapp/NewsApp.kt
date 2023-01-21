package com.david.composepractice.udemy.newsapp

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.david.composepractice.udemy.newsapp.screens.DetailsScreen
import com.david.composepractice.udemy.newsapp.screens.TopNews

@Composable
fun NewsApp() {
    val newsNavController = rememberNavController()
    val newsAppScrollState = rememberScrollState()
    NavHost(navController = newsNavController, startDestination = "TopNews") {
        composable("TopNews") {
            TopNews(navController = newsNavController)
        }
        composable(
            "DetailsScreen/{$NEWS_ID_NAV_KEY}", arguments = listOf(navArgument(NEWS_ID_NAV_KEY) {
                type = NavType.IntType
            })
        ) { navEntry ->
            val newsItemId = navEntry.arguments?.getInt(NEWS_ID_NAV_KEY)
            val newsItem = MockData.getNewsItemById(newsItemId)
            DetailsScreen(navController = newsNavController, newsItem, newsAppScrollState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}