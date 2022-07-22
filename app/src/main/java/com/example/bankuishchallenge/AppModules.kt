package com.example.bankuishchallenge

import android.app.Application
import com.example.bankuishchallenge.conection.ConnectionModule
import com.example.bankuishchallenge.repository.RepositoryModule
import com.example.bankuishchallenge.ui.UIModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppModules : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppModules)
            modules(
                *ConnectionModule.all,
                *RepositoryModule.all,
                *UIModules.all,
                *PagingModule.all
            )
        }
    }
}