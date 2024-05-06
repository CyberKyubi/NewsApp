package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface

class SetIsFirstTimeLaunchUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    suspend fun execute(value: Boolean) {
        userPreferencesInterface.setIsFirstTimeLaunch(value)
    }
}