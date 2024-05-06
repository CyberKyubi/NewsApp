package com.cyberkyubi.nuntium.di

import com.cyberkyubi.domain.local.usecase.GetIsFirstTimeLaunchUseCase
import com.cyberkyubi.domain.local.usecase.GetSelectedCategoriesUseCase
import com.cyberkyubi.domain.local.usecase.GetUserPreferencesUseCase
import com.cyberkyubi.domain.local.usecase.ResetUserPreferencesUseCase
import com.cyberkyubi.domain.local.usecase.SaveSelectedCategoriesUseCase
import com.cyberkyubi.domain.local.usecase.SetIsFirstTimeLaunchUseCase
import com.cyberkyubi.domain.remote.homepage.newsfeed.usecase.GetNewsFeedUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetUserPreferencesUseCase(userPreferencesInterface = get()) }
    factory { SetIsFirstTimeLaunchUseCase(userPreferencesInterface = get()) }
    factory { GetIsFirstTimeLaunchUseCase(userPreferencesInterface = get()) }
    factory { ResetUserPreferencesUseCase(userPreferencesInterface = get()) }
    factory { SaveSelectedCategoriesUseCase(userPreferencesInterface = get()) }
    factory { GetSelectedCategoriesUseCase(userPreferencesInterface = get()) }

    factory { GetNewsFeedUseCase(repository = get()) }

}