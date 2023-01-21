package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.runtime.Composable
import com.david.composepractice.udemy.newsapp.model.CategoryArticle
import com.david.composepractice.udemy.newsapp.network.NewsManager
import com.david.composepractice.udemy.newsapp.uicomponents.CategoryList

@Composable
fun CategoriesScreen(
    categoryList: List<CategoryArticle>,
    newsManager: NewsManager,
    onCategoryClick: (CategoryArticle) -> Unit
) {
    CategoryList(categoryList = categoryList, newsManager, onCategoryClick)
}