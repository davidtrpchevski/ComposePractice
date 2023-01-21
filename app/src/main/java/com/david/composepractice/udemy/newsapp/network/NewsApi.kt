package com.david.composepractice.udemy.newsapp.network

import com.david.composepractice.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApi {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("${BuildConfig.API_URL}${BuildConfig.API_VERSION}")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    val retrofitService by lazy { retrofit.create(NewsService::class.java) }
}