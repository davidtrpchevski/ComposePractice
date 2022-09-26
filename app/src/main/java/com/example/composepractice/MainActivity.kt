package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composepractice.ui.layouts.unit1.SimpleLayoutTryout
import com.example.composepractice.ui.layouts.unit1.TaskCompletedLayout
import com.example.composepractice.ui.layouts.unit2.DiceRollerApp
import com.example.composepractice.ui.layouts.unit2.LemonadeApp
import com.example.composepractice.ui.layouts.unit2.LemonadeCodeLabApp
import com.example.composepractice.ui.layouts.unit3.TipTimeCalculatorApp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                TipTimeCalculatorApp()
            }
        }
    }

    @Composable
    fun InitialProjectLayout() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SimpleLayoutTryout(greetingText = "David", buttonText = "Click Here")
        }
    }
}
