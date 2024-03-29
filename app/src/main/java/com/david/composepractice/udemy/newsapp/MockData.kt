package com.david.composepractice.udemy.newsapp

import com.david.composepractice.R
import com.david.composepractice.udemy.newsapp.model.CategoryTabArticleModel
import com.david.composepractice.udemy.newsapp.model.NewsDataModel

object MockData {
    val topNewsList = listOf(
        NewsDataModel(
            1,
            author = "Raja Razek, CNN",
            title = "'Tiger King' Joe Exotic says he has been diagnosed with aggressive form of prostate cancer - CNN",
            description = "Joseph Maldonado, known as Joe Exotic on the 2020 Netflix docuseries \\\"Tiger King: Murder, Mayhem and Madness,\\\" has been diagnosed with an aggressive form of prostate cancer, according to a letter written by Maldonado.",
            publishedAt = "2021-11-04T05:35:21Z"
        ),
        NewsDataModel(
            2,
            R.drawable.husky,
            author = "Namita Singh",
            title = "Cleo Smith news — live: Kidnap suspect 'in hospital again' as 'hard police grind' credited for breakthrough - The Independent",
            description = "The suspected kidnapper of four-year-old Cleo Smith has been treated in hospital for a second time amid reports he was “attacked” while in custody.",
            publishedAt = "2021-11-04T04:42:40Z"
        ),
        NewsDataModel(
            3,
            R.drawable.android_logo,
            author = "Not available",
            title = "'You are not alone': EU Parliament delegation tells Taiwan on first official visit - Reuters",
            description =
            "The European Parliament's first official delegation to Taiwan said on Thursday the diplomatically isolated island is not alone and called for bolder actions to strengthen EU-Taiwan ties as Taipei faces rising pressure from Beijing.",
            publishedAt = "2021-11-04T03:37:00Z"
        ),
        NewsDataModel(
            4,
            R.drawable.husky,
            author = "Mike Florio",
            title = "Aaron Rodgers violated COVID protocol by doing maskless indoor press conferences - NBC Sports",
            description = "Packers quarterback Aaron Rodgers has been conducting in-person press conferences in the Green Bay facility without wearing a mask. Because he was secretly unvaccinated, Rodgers violated the rules.",
            publishedAt = "2021-11-04T03:21:00Z"
        ),
        NewsDataModel(
            5,
            R.drawable.bg_compose_background,
            author = "Grant Brisbee",
            title = "Buster Posey's career was like no other in Giants history - The Athletic",
            description = "There was a franchise without Buster Posey, and there was one with him, and those two franchises were radically, impossibly different.",
            publishedAt = "2021-11-04T02:12:54Z"
        ),
        NewsDataModel(
            6,
            author = "Michael Schneider",
            title = "‘The Masked Singer’ Reveals Identity of the Beach Ball: Here Are the Stars Under the Mask - Variety",
            description = "SPOILER ALERT: Do not read ahead if you have not watched “The Masked Singer” Season 6, Episode 8, “Giving Thanks,” which aired November 3 on Fox. Honey Boo Boo, we hardly knew you. Reality TV mother and daughter stars June Edith “Mama June” Shannon and Alana …",
            publishedAt = "2021-11-04T02:00:00Z"
        ),
        NewsDataModel(
            7,
            R.drawable.android_logo,
            author = "Thomas Barrabi",
            title = "Sen. Murkowski slams Dems over 'show votes' on federal election bills - Fox News",
            description = "Sen. Lisa Murkowski, R-Alaska, slammed Senate Democrats for pursuing “show votes” on federal election bills on Wednesday as Republicans used the filibuster to block consideration the John Lewis Voting Rights Advancement Act.",
            publishedAt = "2021-11-04T01:57:36Z"
        ),
        NewsDataModel(
            8,
            author = "CBSBoston.com Staff",
            title = "Principal Beaten Unconscious At Dorchester School; Classes Canceled Thursday - CBS Boston",
            description = "Principal Patricia Lampron and another employee were assaulted at Henderson Upper Campus during dismissal on Wednesday.",
            publishedAt = "2021-11-04T01:55:00Z"
        )
    )

    fun getNewsItemById(id: Int?) = topNewsList.first { it.id == id }

    val getAllCategories = listOf(
        CategoryTabArticleModel.BUSINESS,
        CategoryTabArticleModel.GENERAL,
        CategoryTabArticleModel.HEALTH,
        CategoryTabArticleModel.SCIENCE,
        CategoryTabArticleModel.ENTERTAINMENT,
        CategoryTabArticleModel.SPORTS,
        CategoryTabArticleModel.TECHNOLOGY
    )

    fun getCategoryByName(categoryName: String) = CategoryTabArticleModel.valueOf(categoryName)
}