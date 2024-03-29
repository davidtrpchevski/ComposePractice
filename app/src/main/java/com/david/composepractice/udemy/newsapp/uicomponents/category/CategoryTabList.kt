package com.david.composepractice.udemy.newsapp.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.CategoryTabArticleModel
import com.david.composepractice.udemy.newsapp.network.NewsManager


@Composable
fun CategoryTabList(
    categoryList: List<CategoryTabArticleModel>,
    newsManager: NewsManager,
    onCategoryClick: (CategoryTabArticleModel) -> Unit
) {
    Column(modifier = Modifier) {
        LazyRow {
            items(categoryList) { categoryItem ->
                CategoryTabItem(
                    categoryTabArticleModel = categoryItem,
                    isSelected = newsManager.selectedCategory.value == categoryItem,
                    onCategoryClick = onCategoryClick
                )
            }
        }
    }
}

@Composable
fun CategoryTabItem(
    categoryTabArticleModel: CategoryTabArticleModel,
    isSelected: Boolean = false,
    onCategoryClick: (CategoryTabArticleModel) -> Unit = { _ -> }
) {
    Surface(
        color = colorResource(id = if (isSelected) R.color.purple_200 else R.color.purple_700),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 12.dp)
            .clickable { onCategoryClick(categoryTabArticleModel) }
    ) {
        Text(
            text = categoryTabArticleModel.categoryName,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    CategoryTabItem(categoryTabArticleModel = CategoryTabArticleModel.SPORTS)
}