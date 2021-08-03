package com.example.myapplication.data.repository

import com.example.myapplication.data.model.RepoResponseModel
import com.example.myapplication.data.network.ApiInterface
import com.example.myapplication.domain.repository.AppRepository
import io.reactivex.Single

class AppRepositoryImpl(private val apiInterface: ApiInterface): AppRepository {

    override fun getRepositoryData(url :String): Single<RepoResponseModel> {
        return apiInterface.getPopularRepo(url)
    }

}