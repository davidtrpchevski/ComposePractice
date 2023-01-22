package com.david.composepractice.udemy.newsapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopNewsSourceModel(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?
)