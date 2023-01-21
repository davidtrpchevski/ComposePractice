package com.david.composepractice.udemy.newsapp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.david.composepractice.udemy.newsapp.model.BottomNavigationDestination
import com.david.composepractice.udemy.newsapp.screens.CategoriesScreen
import com.david.composepractice.udemy.newsapp.screens.DetailsScreen
import com.david.composepractice.udemy.newsapp.screens.SourcesScreen
import com.david.composepractice.udemy.newsapp.screens.TopNews
import com.david.composepractice.udemy.newsapp.uicomponents.NewsAppBottomNavBar

@Composable
fun NewsApp() {
    val newsNavController = rememberNavController()
    val newsAppScrollState = rememberScrollState()
    val bottomNavigationEntries = listOf(
        BottomNavigationDestination.TopNews,
        BottomNavigationDestination.Categories,
        BottomNavigationDestination.Sources
    )

    Scaffold(bottomBar = {
        NewsAppBottomNavBar(
            navController = newsNavController, navigationEntriesList = bottomNavigationEntries
        )
    }) {
        it
        MainNavigation(navHostController = newsNavController, scrollState = newsAppScrollState)
    }
}

@Composable
fun MainNavigation(navHostController: NavHostController, scrollState: ScrollState) {
    NavHost(navController = navHostController, startDestination = "TopNews") {
        setupBottomNavigation(navHostController)
        composable("TopNews") {
            TopNews(navController = navHostController)
        }
        composable(
            "DetailsScreen/{$NEWS_ID_NAV_KEY}", arguments = listOf(navArgument(NEWS_ID_NAV_KEY) {
                type = NavType.IntType
            })
        ) { navEntry ->
            val newsItemId = navEntry.arguments?.getInt(NEWS_ID_NAV_KEY)
            val newsItem = MockData.getNewsItemById(newsItemId)
            DetailsScreen(navController = navHostController, newsItem, scrollState)
        }
    }
}

fun NavGraphBuilder.setupBottomNavigation(navHostController: NavHostController) {
    composable(BottomNavigationDestination.TopNews.route) {
        TopNews(navController = navHostController)
    }
    composable(BottomNavigationDestination.Categories.route) {
        CategoriesScreen()
    }
    composable(BottomNavigationDestination.Sources.route) {
        SourcesScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}