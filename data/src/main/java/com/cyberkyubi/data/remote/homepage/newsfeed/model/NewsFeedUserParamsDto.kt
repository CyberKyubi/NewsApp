package com.cyberkyubi.data.remote.homepage.newsfeed.model

import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeedUserParamsRequest
import com.google.gson.annotations.SerializedName

data class NewsFeedUserParamsDto(
    @SerializedName("token") val token: String?,
    @SerializedName("topics") val topics: List<String>,
    @SerializedName("page") val page: Int
)

fun NewsFeedUserParamsRequest.fromDomain() = NewsFeedUserParamsDto(token, topics, page)