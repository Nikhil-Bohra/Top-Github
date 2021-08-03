package com.example.myapplication.presentation.di

import com.example.myapplication.BaseApplication
import com.example.myapplication.presentation.view.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppComponent {

    fun inject(appController: BaseApplication)

    fun inject(activity: MainActivity)

}