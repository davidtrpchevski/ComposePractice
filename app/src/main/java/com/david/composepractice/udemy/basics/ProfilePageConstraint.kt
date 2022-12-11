package com.david.composepractice.udemy.basics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.david.composepractice.R

@Composable
fun ProfilePageConstraint() {

    Card(elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 100.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Blue)) {

        ConstraintLayout {

            val (profileImage, nameText, locationText, profileInteraction, buttonFollow, buttonMessage) = createRefs()
            val profilePageGuidelineTop = createGuidelineFromTop(0.1F)

            Image(painter = painterResource(id = R.drawable.husky),
                contentDescription = "Husky",
                Modifier
                    .padding(6.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                    .constrainAs(profileImage) {
//                        top.linkTo(parent.top)
                        top.linkTo(profilePageGuidelineTop)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop)

            Text(text = "Siberian Husky",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(nameText) {
                    top.linkTo(profileImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
            Text(text = "Germany", modifier = Modifier.constrainAs(locationText) {
                top.linkTo(nameText.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            ProfileInteractionRowConstraint(modifier = Modifier.constrainAs(profileInteraction) {
                top.linkTo(locationText.bottom)
            }) {
                ProfileStats(count = "150", title = "Followers")
                ProfileStats(count = "150", title = "Following")
                ProfileStats(count = "30", title = "Posts")
            }

            Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(buttonFollow) {
                start.linkTo(parent.start)
                end.linkTo(buttonMessage.start)
                top.linkTo(profileInteraction.bottom)
                width = Dimension.wrapContent
            }) {
                Text(text = "Follow user")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(buttonMessage) {
                end.linkTo(parent.end)
                start.linkTo(buttonFollow.end)
                top.linkTo(profileInteraction.bottom)
                width = Dimension.wrapContent
            }) {
                Text(text = "Direct message")
            }

        }
    }
}

@Composable
fun ProfileInteractionRowConstraint(modifier: Modifier, element: @Composable () -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        element()
    }
}

@Composable
fun ProfileStatsConstraint(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePageConstraintPreview() {
    ProfilePageConstraint()
}