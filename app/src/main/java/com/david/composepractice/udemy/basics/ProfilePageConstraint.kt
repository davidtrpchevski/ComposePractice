package com.david.composepractice.udemy.basics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
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
    ProfilePageConstraintLandscapeAndPortrait()
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val profileImage = createRefFor("profileImage")
        val nameText = createRefFor("nameText")
        val locationText = createRefFor("locationText")
        val profileInteraction = createRefFor("profileInteraction")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val profilePageGuidelineTop = createGuidelineFromTop(0.1F)

        constrain(profileImage) {
            top.linkTo(profilePageGuidelineTop)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText) {
            top.linkTo(profileImage.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(locationText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(profileInteraction) {
            top.linkTo(locationText.bottom)
        }
        constrain(buttonFollow) {
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            top.linkTo(profileInteraction.bottom, margin = margin)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage) {
            end.linkTo(parent.end)
            start.linkTo(buttonFollow.end)
            top.linkTo(profileInteraction.bottom, margin = margin)
            width = Dimension.wrapContent
        }
    }
}

private fun landScapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val profileImage = createRefFor("profileImage")
        val nameText = createRefFor("nameText")
        val locationText = createRefFor("locationText")
        val profileInteraction = createRefFor("profileInteraction")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        constrain(profileImage) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }
        constrain(nameText) {
            start.linkTo(profileImage.start)
            top.linkTo(profileImage.bottom)
        }
        constrain(locationText) {
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(profileInteraction) {
            top.linkTo(profileImage.top)
            start.linkTo(profileImage.end, margin = margin)
            end.linkTo(parent.end)
        }

        constrain(buttonFollow) {
            top.linkTo(profileInteraction.bottom, margin = margin)
            start.linkTo(profileInteraction.start)
            end.linkTo(buttonMessage.start)
            bottom.linkTo(locationText.bottom)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage) {
            top.linkTo(profileInteraction.bottom, margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(locationText.bottom)
            width = Dimension.wrapContent
        }
    }
}

@Composable
fun ProfilePageConstraintLandscapeAndPortrait() {

    Card(elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 100.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Blue)) {

        BoxWithConstraints {
            // @param[margin] for adding equal spaces between required element
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                landScapeConstraints(16.dp)
            }
            ConstraintLayout(constraints) {

                Image(painter = painterResource(id = R.drawable.husky),
                    contentDescription = "Husky",
                    Modifier
                        .padding(6.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                        .layoutId("profileImage"),
                    contentScale = ContentScale.Crop)

                Text(
                    text = "Siberian Husky",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("nameText")
                )
                Text(text = "Germany", modifier = Modifier.layoutId("locationText"))

                ProfileInteractionRowConstraint(modifier = Modifier.layoutId("profileInteraction")) {
                    ProfileStats(count = "150", title = "Followers")
                    ProfileStats(count = "150", title = "Following")
                    ProfileStats(count = "30", title = "Posts")
                }

                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonFollow")) {
                    Text(text = "Follow user")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonMessage")) {
                    Text(text = "Direct message")
                }

            }
        }
    }
}