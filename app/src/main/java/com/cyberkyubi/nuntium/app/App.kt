package com.cyberkyubi.nuntium.app

import android.app.Application
import com.cyberkyubi.nuntium.di.viewModelModule
import com.cyberkyubi.nuntium.di.localModule
import com.cyberkyubi.nuntium.di.networkModule
import com.cyberkyubi.nuntium.di.remoteModule
import com.cyberkyubi.nuntium.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(viewModelModule, localModule, networkModule, remoteModule, useCaseModule))
        }
    }
}