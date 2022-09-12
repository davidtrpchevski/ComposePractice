package com.example.composepractice.ui.layouts.unit1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R

@Composable
@Preview(showBackground = true)
fun TaskCompletedPreview() {
    TaskCompletedLayout()
}

@Composable
fun TaskCompletedLayout() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        TaskCompleted()
    }
}

@Composable
fun TaskCompleted() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskCompletedImage()
        TaskCompletedText()
        TaskCompletedMessage()
    }
}

@Composable
fun TaskCompletedImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_task_completed),
        contentDescription = null
    )
}

@Composable
fun TaskCompletedText() {
    Text(
        text = stringResource(R.string.task_completed_status),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun TaskCompletedMessage() {
    Text(text = stringResource(R.string.task_message), fontSize = 16.sp)
}
