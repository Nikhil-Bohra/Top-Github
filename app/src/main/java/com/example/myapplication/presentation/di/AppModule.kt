package com.example.myapplication.presentation.di

import com.example.myapplication.data.network.ApiClient
import com.example.myapplication.data.network.ApiInterface
import com.example.myapplication.data.repository.AppRepositoryImpl
import com.example.myapplication.domain.repository.AppRepository
import com.example.myapplication.domain.usecase.RepoUseCase
import com.example.myapplication.presentation.view.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
     fun provideAppRepository(apiInterface: ApiInterface) : AppRepository{
         return AppRepositoryImpl(apiInterface)
     }

    @Provides
    fun provideApiInterface() :ApiInterface {
        return ApiClient.buildService(ApiInterface::class.java)
    }

    @Provides
    fun provideMainViewModel(repoUseCase: RepoUseCase) :MainViewModel {
        return MainViewModel(repoUseCase)
    }
}