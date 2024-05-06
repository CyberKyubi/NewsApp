package com.cyberkyubi.domain.local.model

data class UserPreferences(
    val isFirstTimeLaunch: Boolean,
    val isAuthorized: Boolean,
    val selectedCategories: List<String>
)