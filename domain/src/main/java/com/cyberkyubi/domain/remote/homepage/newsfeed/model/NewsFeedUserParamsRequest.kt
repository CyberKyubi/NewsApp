package com.cyberkyubi.domain.remote.homepage.newsfeed.model

data class NewsFeedUserParamsRequest(
    val token: String?,
    val topics: List<String>,
    val page: Int
)
