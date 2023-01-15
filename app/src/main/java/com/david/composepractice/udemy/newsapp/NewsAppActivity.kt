package com.david.composepractice.udemy.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.david.composepractice.ui.theme.ComposePracticeTheme

class NewsAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                NewsApp()
            }
        }
    }
}
