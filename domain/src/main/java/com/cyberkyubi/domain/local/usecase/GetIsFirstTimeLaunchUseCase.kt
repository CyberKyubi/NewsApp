package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface
import kotlinx.coroutines.flow.Flow

class GetIsFirstTimeLaunchUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    fun execute(): Flow<Boolean> {
        return userPreferencesInterface.isFirstTimeLaunch
    }
}