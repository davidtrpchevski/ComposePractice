package com.example.composepractice.ui.layouts.unit1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R

@Composable
@Preview(showBackground = true)
fun BirthdayCardPreview() {
    BirthdayCard()
}


@Composable
fun BirthdayCard() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        FullLayout("Sam", "David")
    }
}

@Composable
fun FullLayout(toText: String, fromText: String) {
    Box() {
        BirthdayCardImage()
        BirthdayGreetingText(toText = toText, fromText = fromText)
    }

    // Bottom Centered
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NameGreeting(name = toText)
        FromWhoCard(fromText)
    }
}

@Composable
fun BirthdayGreetingText(toText: String, fromText: String) {
    Column() {
        NameGreeting(name = toText)
        FromWhoCard(nameSender = fromText)
    }
}

@Composable
fun NameGreeting(name: String) {
    Text(text = stringResource(R.string.name_sam), fontSize = 36.sp)
}

@Composable
fun FromWhoCard(nameSender: String) {
    Text(
        text = "From $nameSender",
        fontSize = 24.sp,
        color = Color.Blue,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun BirthdayCardImage() {
    val birthdayImage = painterResource(id = R.drawable.androidparty)
    Image(
        painter = birthdayImage,
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}