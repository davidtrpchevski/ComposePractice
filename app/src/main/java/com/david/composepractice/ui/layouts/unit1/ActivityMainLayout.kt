package com.david.composepractice.ui.layouts.unit1

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.composepractice.ui.theme.ComposePracticeTheme


@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Center,
            color = Color.Green,
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun GreetingButton(buttonText: String) {
    Button(
        onClick = ::doOnButtonClick,
        modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Text(text = buttonText)
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    ComposePracticeTheme {
        SimpleLayoutTryout(greetingText = "David", buttonText = "Click Here")
    }
}

fun doOnButtonClick() {
    Log.d("Button", "Clicked")
}

@Composable
fun SimpleLayoutTryout(greetingText: String, buttonText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Greeting(name = greetingText)
        GreetingButton(buttonText = buttonText)
    }
}