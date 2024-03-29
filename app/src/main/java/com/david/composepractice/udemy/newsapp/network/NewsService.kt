package com.david.composepractice.udemy.newsapp.network

import com.david.composepractice.udemy.newsapp.model.TopNewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun getTopArticles(
        @Query("country") country: String?,
        @Query("category") category: String?
    ): Call<TopNewsModel>

    @GET("everything")
    fun getArticlesBySources(
        @Query("sources") source: String?,
        @Query("q") query: String?
    ): Call<TopNewsModel>
}