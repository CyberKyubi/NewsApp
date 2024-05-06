package com.cyberkyubi.domain.local.usecase

import com.cyberkyubi.domain.local.UserPreferencesInterface

class SaveSelectedCategoriesUseCase(private val userPreferencesInterface: UserPreferencesInterface) {

    suspend fun execute(categories: List<String>) {
        userPreferencesInterface.saveSelectedCategories(categories)
    }
}