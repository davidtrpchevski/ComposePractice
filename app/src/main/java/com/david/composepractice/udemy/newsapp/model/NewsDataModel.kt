package com.david.composepractice.udemy.newsapp.model

import com.david.composepractice.R

data class NewsDataModel(
    val id: Int,
    val image: Int = R.drawable.androidparty,
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String
)