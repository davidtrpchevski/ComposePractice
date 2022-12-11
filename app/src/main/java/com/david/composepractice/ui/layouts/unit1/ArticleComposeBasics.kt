package com.david.composepractice.ui.layouts.unit1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.R

@Composable
@Preview(showBackground = true)
fun PreviewArticle() {
    TutorialFullLayout()
}

@Composable
fun TutorialFullLayout() {
    Column {
        TutorialImage()
        TutorialHeading()
        TutorialSummary()
        TutorialContent()
    }
}

@Composable
fun TutorialImage() {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TutorialHeading() {
    Text(
        text = stringResource(R.string.tutorial_heading),
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun TutorialSummary() {
    Text(
        text = stringResource(R.string.tutorial_summary),
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun TutorialContent() {
    Text(
        text = stringResource(id = R.string.tutorial_content),
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}