package com.david.composepractice.udemy.newsapp.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Details
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel

@Composable
fun DetailsScreen(
    navController: NavController, newsDataModel: TopNewsArticleModel?, scrollState: ScrollState
) {
    Scaffold(topBar = {
        DetailsTopAppBar {
            navController.popBackStack()
        }
    }) { paddingValues ->
        DetailsContent(navController, newsDataModel, scrollState, paddingValues)
    }
}

@Composable
fun ItemRowInfo(icon: ImageVector, title: String) {
    Row(modifier = Modifier) {
        Icon(imageVector = icon, contentDescription = title)
        Text(text = title)
    }
}

@Composable
fun DetailsTopAppBar(onBackPressed: () -> Unit) {
    TopAppBar(title = {
        Text(text = "Details Screen", fontWeight = FontWeight.SemiBold)
    }, navigationIcon = {
        IconButton(onClick = onBackPressed) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        }
    })
}

@Composable
fun DetailsContent(
    navController: NavController,
    newsDataModel: TopNewsArticleModel?,
    scrollState: ScrollState,
    paddingValues: PaddingValues
) {
    newsDataModel?.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(paddingValues)
        ) {
            Text(text = "Details Screen")
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Navigate to topNews")
            }
            AsyncImage(
                model = newsDataModel.urlToImage,
                contentDescription = newsDataModel.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight(.8f)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                ItemRowInfo(
                    icon = Icons.Outlined.Details, title = newsDataModel.author ?: stringResource(
                        R.string.item_not_available
                    )
                )
                ItemRowInfo(
                    icon = Icons.Outlined.CalendarMonth,
                    title = newsDataModel.publishedAt ?: stringResource(R.string.item_not_available)
                )
            }
            Text(
                text = newsDataModel.title ?: stringResource(R.string.item_not_available),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Text(text = newsDataModel.description ?: stringResource(R.string.item_not_available))
        }
    }
}
