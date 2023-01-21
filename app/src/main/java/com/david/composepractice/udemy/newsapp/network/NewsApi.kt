package com.david.composepractice.udemy.newsapp.network

import com.david.composepractice.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsApi {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpInterceptor = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader("X-Api-key", BuildConfig.API_KEY)
            chain.proceed(builder.build())
        }
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("${BuildConfig.API_URL}${BuildConfig.API_VERSION}")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpInterceptor)
            .build()

    val retrofitService: NewsService by lazy { retrofit.create(NewsService::class.java) }
}