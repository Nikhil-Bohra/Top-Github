package com.example.myapplication

import android.app.Application
import com.example.myapplication.presentation.di.AppComponent
import com.example.myapplication.presentation.di.DaggerAppComponent
import java.security.AccessControlContext

class BaseApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.create()
    }


}