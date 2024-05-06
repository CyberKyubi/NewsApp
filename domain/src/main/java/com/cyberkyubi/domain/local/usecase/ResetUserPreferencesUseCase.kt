package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface

class ResetUserPreferencesUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    suspend fun execute() {
        userPreferencesInterface.resetPreferences()
    }
}