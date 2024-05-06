package com.cyberkyubi.domain.local

import com.cyberkyubi.domain.local.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesInterface {
    suspend fun setIsFirstTimeLaunch(isFirstTimeLaunch: Boolean)
    suspend fun setIsAuthorized(isAuthorized: Boolean)
    suspend fun saveSelectedCategories(categories: List<String>)
    val selectedCategories: Flow<List<String>>
    val isFirstTimeLaunch: Flow<Boolean>
    val isAuthorized: Flow<Boolean>
    val userPreferences: Flow<UserPreferences>
    suspend fun resetPreferences()


}