package com.cyberkyubi.nuntium.di

import com.cyberkyubi.data.remote.homepage.newsfeed.NewsFeedRepositoryImpl
import com.cyberkyubi.domain.remote.homepage.newsfeed.NewsFeedRepository
import org.koin.dsl.module

val remoteModule = module {
    single<NewsFeedRepository> { NewsFeedRepositoryImpl(get())  }
}
