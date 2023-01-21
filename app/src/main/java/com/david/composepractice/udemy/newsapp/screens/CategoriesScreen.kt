package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.david.composepractice.udemy.newsapp.model.CategoryTabArticleModel
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel
import com.david.composepractice.udemy.newsapp.network.NewsManager
import com.david.composepractice.udemy.newsapp.uicomponents.CategoryList
import com.david.composepractice.udemy.newsapp.uicomponents.CategoryTabList

@Composable
fun CategoriesScreen(
    categoryTabArticleList: List<CategoryTabArticleModel>,
    categoryList: List<TopNewsArticleModel?>?,
    newsManager: NewsManager,
    onCategoryClick: (CategoryTabArticleModel) -> Unit
) {
    Column {
        CategoryTabList(categoryList = categoryTabArticleList, newsManager, onCategoryClick)
        CategoryList(categoriesList = categoryList)
    }
}