package com.cyberkyubi.domain.remote.homepage.newsfeed

import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeed
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeedUserParamsRequest
import com.cyberkyubi.domain.utils.Either
import com.cyberkyubi.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow

interface NewsFeedRepository {
    fun getNewsFeed(userParams: NewsFeedUserParamsRequest): Flow<Either<NetworkError, NewsFeed>>
}