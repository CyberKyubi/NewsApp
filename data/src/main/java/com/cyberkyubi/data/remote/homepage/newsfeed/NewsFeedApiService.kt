package com.cyberkyubi.data.remote.homepage.newsfeed

import com.cyberkyubi.data.remote.homepage.newsfeed.model.NewsFeedResponse
import com.cyberkyubi.data.remote.homepage.newsfeed.model.NewsFeedUserParamsDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NewsFeedApiService {
    @POST("newsFeed")
    suspend fun getNewsFeed(@Body userParamsDto: NewsFeedUserParamsDto): Response<NewsFeedResponse>
}