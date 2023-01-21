package com.david.composepractice.udemy.newsapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopNewsModel(
    @Json(name = "articles")
    val topNewsArticleModels: List<TopNewsArticleModel?>? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "totalResults")
    val totalResults: Int? = null
)