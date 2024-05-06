package com.cyberkyubi.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.cyberkyubi.domain.local.model.UserPreferences
import com.cyberkyubi.domain.local.UserPreferencesInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

object PreferencesKeys {
    const val IS_FIRST_TIME_LAUNCH = "IS_FIRST_TIME_LAUNCH"
    const val IS_AUTHORIZED = "IS_AUTHORIZED"
    const val NAME = "nuntium_settings"
    const val SELECTED_CATEGORIES = "SELECTED_CATEGORIES"
}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PreferencesKeys.NAME)

class UserPreferencesImpl(private val context: Context): UserPreferencesInterface {

    override suspend fun setIsFirstTimeLaunch(isFirstTimeLaunch: Boolean) {
        context.dataStore.edit { pref ->
            pref[booleanPreferencesKey(PreferencesKeys.IS_FIRST_TIME_LAUNCH)] = isFirstTimeLaunch
        }
    }

    override suspend fun setIsAuthorized(isAuthorized: Boolean) {
        context.dataStore.edit { pref ->
            pref[booleanPreferencesKey(PreferencesKeys.IS_AUTHORIZED)] = isAuthorized
        }
    }

    override suspend fun saveSelectedCategories(categories: List<String>) {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey(PreferencesKeys.SELECTED_CATEGORIES)] = categories.joinToString()
        }
    }

    override val isFirstTimeLaunch: Flow<Boolean> = context.dataStore.data.map { pref ->
        pref[booleanPreferencesKey(PreferencesKeys.IS_FIRST_TIME_LAUNCH)] ?: true
    }

    override val isAuthorized: Flow<Boolean> = context.dataStore.data.map { pref ->
        pref[booleanPreferencesKey(PreferencesKeys.IS_AUTHORIZED)] ?: false
    }

    override val selectedCategories: Flow<List<String>> = context.dataStore.data.map { pref ->
        val categoriesString =  pref[stringPreferencesKey(PreferencesKeys.SELECTED_CATEGORIES)]
        if (!categoriesString.isNullOrBlank()) {
            categoriesString.split(", ")
        } else {
            emptyList()
        }
    }

    override val userPreferences: Flow<UserPreferences> =
        combine(
            isFirstTimeLaunch,
            isAuthorized,
            selectedCategories
        ) { isFirstTimeLaunch, isAuthorized, selectedCategories ->
        UserPreferences(isFirstTimeLaunch, isAuthorized, selectedCategories)
    }

    override suspend fun resetPreferences() {
        context.dataStore.edit { pref ->
            pref[booleanPreferencesKey(PreferencesKeys.IS_FIRST_TIME_LAUNCH)] = true
            pref[booleanPreferencesKey(PreferencesKeys.IS_AUTHORIZED)] = false
            pref[stringPreferencesKey(PreferencesKeys.SELECTED_CATEGORIES)] = ""
        }
    }
}