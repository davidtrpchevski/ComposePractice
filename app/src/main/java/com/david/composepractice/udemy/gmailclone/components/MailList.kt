package com.david.composepractice.udemy.gmailclone.components

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.udemy.gmailclone.mockMailList
import com.david.composepractice.udemy.gmailclone.model.MailItemModel

@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .scrollable(scrollState, Orientation.Vertical)
        ) {
            items(mockMailList) { item: MailItemModel ->
                MailItem(mailItemModel = item)
            }
        }
    }
}

@Composable
fun MailItem(mailItemModel: MailItemModel, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = mailItemModel.firstNameLetter, textAlign = TextAlign.Center)
        }
        Column(modifier = modifier.weight(2f)) {
            Text(
                text = mailItemModel.username,
                color = Color.Blue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = mailItemModel.subject, color = Color.Black, fontSize = 15.sp)
            Text(text = mailItemModel.body, color = Color.Gray, fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = mailItemModel.timeStamp, color = Color.Black, fontSize = 12.sp)
            IconButton(onClick = { Log.d("MailList", "Added to favorites") }) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "Favorites")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    MailItem(MailItemModel("David", "Important Subject", "Some non important body", "21:20"))
}