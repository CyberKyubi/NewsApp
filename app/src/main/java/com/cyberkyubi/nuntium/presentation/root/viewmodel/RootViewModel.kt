package com.cyberkyubi.nuntium.presentation.root.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cyberkyubi.domain.local.model.UserPreferences
import com.cyberkyubi.domain.local.usecase.GetUserPreferencesUseCase

class RootViewModel(
    getUserPreferencesUseCase: GetUserPreferencesUseCase,
): ViewModel() {

    val userPreferences: LiveData<UserPreferences> = getUserPreferencesUseCase.execute().asLiveData()

}