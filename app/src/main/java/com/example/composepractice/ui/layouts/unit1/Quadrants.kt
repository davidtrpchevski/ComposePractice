package com.example.composepractice.ui.layouts.unit1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun QuadrantsLayoutPreview() {
    QuadrantsLayout()
}

@Composable
fun QuadrantsLayout() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            FirstQuadrant()
            SecondQuadrant()
        }
        Row(modifier = Modifier.weight(1f)) {
            ThirdQuadrant()
            FourthQuadrant()
        }
    }
}

@Composable
fun RowScope.FirstQuadrant() {
    QuadrantContent(
        quadrantTitle = "Text composable",
        quadrantContent = "Displays text and follows Material Design guidelines.",
        quadrantColor = Color.Green,
        modifier = Modifier.weight(1f)
    )
}

@Composable
fun RowScope.SecondQuadrant() {
    QuadrantContent(
        quadrantTitle = "Image composable",
        quadrantContent = "Creates a composable that lays out and draws a given Painter class object.",
        quadrantColor = Color.Yellow,
        modifier = Modifier.weight(1f)
    )
}

@Composable
fun RowScope.ThirdQuadrant() {
    QuadrantContent(
        quadrantTitle = "Row composable",
        quadrantContent = "A layout composable that places its children in a horizontal sequence.",
        quadrantColor = Color.Cyan,
        modifier = Modifier.weight(1f)
    )
}

@Composable
fun RowScope.FourthQuadrant() {
    QuadrantContent(
        quadrantTitle = "Column composable",
        quadrantContent = "A layout composable that places its children in a vertical sequence.",
        quadrantColor = Color.LightGray,
        modifier = Modifier.weight(1f)
    )
}

@Composable
fun QuadrantContent(
    quadrantTitle: String,
    quadrantContent: String,
    quadrantColor: Color,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(quadrantColor)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = quadrantTitle,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = quadrantContent, textAlign = TextAlign.Justify)
    }
}