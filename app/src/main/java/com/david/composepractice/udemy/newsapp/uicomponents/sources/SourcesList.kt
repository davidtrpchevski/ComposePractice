package com.david.composepractice.udemy.newsapp.uicomponents.sources

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.TopNewsArticleModel

@Composable
fun SourcesList(
    topNewsArticleModelList: List<TopNewsArticleModel?>?,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(paddingValues)) {
        topNewsArticleModelList?.let {
            items(it) { article ->
                SourcesListItem(topNewsArticleModel = article)
            }
        }
    }
}

@Composable
fun SourcesListItem(topNewsArticleModel: TopNewsArticleModel?, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    topNewsArticleModel?.let {
        val annotatedString = buildAnnotatedString {
            pushStringAnnotation(tag = "URL", annotation = it.url ?: return)
            withStyle(
                style = SpanStyle(
                    colorResource(id = R.color.purple_200),
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Read full article")
            }
        }
        Card(
            backgroundColor = colorResource(id = R.color.purple_700), modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        ) {
            Column(modifier = modifier.padding(8.dp)) {
                Text(text = it.title ?: stringResource(id = R.string.item_not_available))
                Text(text = it.description ?: stringResource(id = R.string.item_not_available))
                Card(backgroundColor = Color.White) {
                    ClickableText(text = annotatedString, onClick = {
                        annotatedString.getStringAnnotations(it, it).firstOrNull()?.let { result ->
                            uriHandler.openUri(result.item)
                        }
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SourcesListItemPreview() {
    SourcesListItem(
        TopNewsArticleModel(
            "David",
            "DAVID",
            "DAVID",
            "DAVID",
            null,
            "DAVID",
            "SOMEURL",
            "https://i.imgur.com/GgELcaV.jpeg"
        )
    )
}