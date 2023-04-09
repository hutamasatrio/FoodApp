package com.example.foodapp

import android.app.Application
import com.example.core.di.mapperModule
import com.example.core.di.networkModule
import com.example.core.di.repositoryModule

import com.example.foodapp.di.useCaseModule
import com.example.foodapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    mapperModule
                )
            )
        }
    }
}