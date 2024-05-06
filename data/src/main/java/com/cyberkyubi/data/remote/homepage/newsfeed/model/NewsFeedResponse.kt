package com.cyberkyubi.data.remote.homepage.newsfeed.model

import com.cyberkyubi.domain.remote.homepage.newsfeed.model.Article
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeed
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.Source
import com.google.gson.annotations.SerializedName

data class NewsFeedResponse(
    @SerializedName("articles") val articles: List<ArticleDto>
)

data class ArticleDto(
    @SerializedName("source") val source: SourceDto,
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publishedAt: String,
)

fun NewsFeedResponse.mapToDomain() = NewsFeed(
    articles = articles.map {
        Article(
            source = Source(
                id = it.source.id,
                name = it.source.name
            ),
            author = it.author,
            title = it.title,
            url = it.url,
            urlToImage = it.urlToImage,
            publishedAt = it.publishedAt,
        )
    }
)

