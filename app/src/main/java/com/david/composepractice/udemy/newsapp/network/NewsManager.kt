package com.david.composepractice.udemy.newsapp.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.david.composepractice.BuildConfig
import com.david.composepractice.udemy.newsapp.model.TopNewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsManager {
    private val _newsResponse = mutableStateOf(TopNewsModel())
    val newsResponse: State<TopNewsModel>
        @Composable get() = remember {
            _newsResponse
        }

    init {
        getArticles()
    }

    private fun getArticles() {
        val service = NewsApi.retrofitService.getTopArticles("us", BuildConfig.API_KEY)
        service.enqueue(object : Callback<TopNewsModel> {
            override fun onResponse(call: Call<TopNewsModel>, response: Response<TopNewsModel>) {
                if (response.isSuccessful) {
                    _newsResponse.value = response.body()!!
                    Log.d("APIERROR", "${_newsResponse.value}")
                } else {
                    Log.d("APIERROR", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<TopNewsModel>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}