package com.david.composepractice.udemy.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.david.composepractice.ui.theme.ComposePracticeTheme

class BasicsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ProfilePageConstraintLandscapeAndPortrait()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name", fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting(name = "Android")
    }
}
