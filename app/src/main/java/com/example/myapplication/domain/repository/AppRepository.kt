package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.RepoResponseModel
import io.reactivex.Single

interface AppRepository {
    fun getRepositoryData(url:String): Single<RepoResponseModel>
}