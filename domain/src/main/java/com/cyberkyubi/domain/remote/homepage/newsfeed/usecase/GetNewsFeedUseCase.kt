package com.cyberkyubi.domain.remote.homepage.newsfeed.usecase

import com.cyberkyubi.domain.remote.homepage.newsfeed.NewsFeedRepository
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeedUserParamsRequest

class GetNewsFeedUseCase(private val repository: NewsFeedRepository) {
    operator fun invoke(userParams: NewsFeedUserParamsRequest) = repository.getNewsFeed(userParams)
}