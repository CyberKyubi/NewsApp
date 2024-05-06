package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface
import com.cyberkyubi.domain.local.model.UserPreferences
import kotlinx.coroutines.flow.Flow

class GetUserPreferencesUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    fun execute(): Flow<UserPreferences> {
        return userPreferencesInterface.userPreferences
    }
}