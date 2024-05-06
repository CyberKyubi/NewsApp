package com.cyberkyubi.nuntium.di

import com.cyberkyubi.data.local.UserPreferencesImpl
import com.cyberkyubi.domain.local.UserPreferencesInterface
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single<UserPreferencesInterface> {
        UserPreferencesImpl(context = androidContext())
    }
}