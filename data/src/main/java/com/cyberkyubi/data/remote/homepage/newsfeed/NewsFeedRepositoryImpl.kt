package com.cyberkyubi.data.remote.homepage.newsfeed

import android.util.Log
import com.cyberkyubi.data.remote.homepage.newsfeed.model.fromDomain
import com.cyberkyubi.data.remote.homepage.newsfeed.model.mapToDomain
import com.cyberkyubi.domain.remote.homepage.newsfeed.NewsFeedRepository
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeed
import com.cyberkyubi.domain.remote.homepage.newsfeed.model.NewsFeedUserParamsRequest
import com.cyberkyubi.domain.utils.Either
import com.cyberkyubi.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsFeedRepositoryImpl(
    private val newsFeedApiService: NewsFeedApiService
): NewsFeedRepository {

    override fun getNewsFeed(userParams: NewsFeedUserParamsRequest): Flow<Either<NetworkError, NewsFeed>> = flow {
        try {
            val response = newsFeedApiService.getNewsFeed(userParams.fromDomain())
            if (response.isSuccessful && response.body() != null) {
                emit(Either.Right(response.body()!!.mapToDomain()))
            } else {
                emit(Either.Left(NetworkError.Api(response.body().toString())))
            }
        } catch (e: Exception) {
            Log.e("ERRRRRRRRRRRRRR", e.localizedMessage ?: "Error getting article feed")
        }
    }
}