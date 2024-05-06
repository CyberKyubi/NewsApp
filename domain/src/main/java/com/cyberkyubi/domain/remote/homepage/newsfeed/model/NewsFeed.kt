package com.cyberkyubi.domain.remote.homepage.newsfeed.model

data class NewsFeed(
    val articles: List<Article>
)

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
)