package com.david.composepractice.udemy.newsapp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.david.composepractice.udemy.newsapp.model.BottomNavigationDestination
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel
import com.david.composepractice.udemy.newsapp.network.NewsManager
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
    val newsManager = NewsManager()
    val articles = newsManager.newsResponse.value.topNewsArticleModels

    Scaffold(bottomBar = {
        NewsAppBottomNavBar(
            navController = newsNavController, navigationEntriesList = bottomNavigationEntries
        )
    }) {
        MainNavigation(
            navHostController = newsNavController,
            scrollState = newsAppScrollState,
            articles,
            newsManager,
            it
        )
    }
}

@Composable
fun MainNavigation(
    navHostController: NavHostController,
    scrollState: ScrollState,
    articles: List<TopNewsArticleModel?>?,
    newsManager: NewsManager,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationDestination.TopNews.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        setupBottomNavigation(navHostController, articles, newsManager)
        composable(
            "DetailsScreen/{$NEWS_ID_NAV_KEY}", arguments = listOf(navArgument(NEWS_ID_NAV_KEY) {
                type = NavType.IntType
            })
        ) { navEntry ->
            val topArticleIndex = navEntry.arguments?.getInt(NEWS_ID_NAV_KEY)
            val topArticle = topArticleIndex?.let { articles?.get(it) }
            DetailsScreen(navController = navHostController, topArticle, scrollState)
        }
    }
}

fun NavGraphBuilder.setupBottomNavigation(
    navHostController: NavHostController,
    articles: List<TopNewsArticleModel?>?,
    newsManager: NewsManager
) {
    composable(BottomNavigationDestination.TopNews.route) {
        TopNews(navController = navHostController, articles)
    }
    composable(BottomNavigationDestination.Categories.route) {
        newsManager.getArticles(category = newsManager.selectedCategory.value?.categoryName)
        CategoriesScreen(
            MockData.getAllCategories,
            newsManager.newsResponse.value.topNewsArticleModels,
            newsManager
        ) { categoryTabArticleModel ->

            newsManager.setSelectedCategory(categoryTabArticleModel)
        }
    }
    composable(BottomNavigationDestination.Sources.route) {
        SourcesScreen(newsManager)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}