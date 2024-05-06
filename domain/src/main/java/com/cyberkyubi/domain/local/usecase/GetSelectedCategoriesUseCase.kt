package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface
import kotlinx.coroutines.flow.Flow

class GetSelectedCategoriesUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    fun execute(): Flow<List<String>> {
        return userPreferencesInterface.selectedCategories
    }
}