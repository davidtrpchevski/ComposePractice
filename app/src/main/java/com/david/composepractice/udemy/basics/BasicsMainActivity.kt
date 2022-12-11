package com.david.composepractice.udemy.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.ui.theme.ComposePracticeTheme

class BasicsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                TextFieldState()
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

@Composable
fun TextFieldState() {

/*    var fieldInput by remember {
        mutableStateOf("")
    }*/

    var fieldInput by rememberSaveable {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name")
        Spacer(modifier = Modifier.size(6.dp))
        TextField(value = fieldInput, onValueChange = {
            fieldInput = it
        })
        Button(onClick = {
            name = fieldInput
        }) {
            Text(text = "Submit")
        }
    }
}