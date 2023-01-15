package com.david.composepractice.udemy.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.david.composepractice.udemy.gmailclone.data.DrawerMenuEntryModel

@Composable
fun GmailDrawerMenu(drawerScrollState: ScrollState) {
    Column(Modifier.verticalScroll(drawerScrollState)) {
        Text(text = "Gmail",
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp))
        DrawerMenuEntryModel.getDrawerMenuItems().forEach {
            when {
                it.isDivider -> Divider(modifier = Modifier.fillMaxWidth(), color = Color.Blue)
                it.isHeader -> Text(text = it.title!!,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp))
                else -> DrawerMenuEntryItem(drawerMenuEntryModel = it)
            }
        }
    }
}

@Composable
fun DrawerMenuEntryItem(drawerMenuEntryModel: DrawerMenuEntryModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Icon(imageVector = drawerMenuEntryModel.icon!!,
            contentDescription = drawerMenuEntryModel.title!!,
            modifier = Modifier.weight(0.2F))
        Text(text = drawerMenuEntryModel.title, modifier = Modifier.weight(1F))
    }
}

@Preview(showBackground = true)
@Composable
fun GmailDrawerMenuPreview() {
//    GmailDrawerMenu()
}