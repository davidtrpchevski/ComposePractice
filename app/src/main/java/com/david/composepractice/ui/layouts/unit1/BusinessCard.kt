package com.david.composepractice.ui.layouts.unit1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.composepractice.R

@Composable
@Preview(showBackground = true)
fun BusinessCardPreview() {
    BusinessCard()
}

@Composable
fun BusinessCard() {
    Surface(modifier = Modifier.fillMaxSize()) {
        BasicContactInfo("David Trpchevski", "Developer")
        AdvancedContactInfo()
    }
}

@Composable
fun BasicContactInfo(contactName: String, contactTitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            Modifier.fillMaxWidth(.5f),
            contentScale = ContentScale.Fit
        )
        Text(text = contactName)
        Text(text = contactTitle)
    }
}

@Composable
fun AdvancedContactInfo() {
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.padding(bottom = 24.dp)) {
        ContactInfoField(fieldIcon = R.drawable.ic_baseline_local_phone, fieldText = "070888826")
        ContactInfoField(fieldIcon = R.drawable.ic_baseline_web, fieldText = "@localmedia")
        ContactInfoField(fieldIcon = R.drawable.ic_baseline_email, fieldText = "email@domain.com")
    }
}

@Composable
fun ContactInfoField(fieldIcon: Int, fieldText: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 46.dp, vertical = 6.dp)
    ) {
        Icon(painter = painterResource(id = fieldIcon), contentDescription = null)
        Text(text = fieldText)
    }
}