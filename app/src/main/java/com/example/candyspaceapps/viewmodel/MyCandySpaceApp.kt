package com.example.candyspaceapps.viewmodel

import android.app.Application
import com.example.candyspaceapps.di.networkModule
import com.example.candyspaceapps.di.vModelMod
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyCandySpaceApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext( this@MyCandySpaceApp)
            modules(listOf(networkModule, vModelMod))
        }
    }
}