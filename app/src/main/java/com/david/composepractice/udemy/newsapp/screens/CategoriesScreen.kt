package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.runtime.Composable
import com.david.composepractice.udemy.newsapp.model.CategoryTabArticleModel
import com.david.composepractice.udemy.newsapp.network.NewsManager
import com.david.composepractice.udemy.newsapp.uicomponents.CategoryTabList

@Composable
fun CategoriesScreen(
    categoryList: List<CategoryTabArticleModel>,
    newsManager: NewsManager,
    onCategoryClick: (CategoryTabArticleModel) -> Unit
) {
    CategoryTabList(categoryList = categoryList, newsManager, onCategoryClick)
}