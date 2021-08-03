package com.example.myapplication.data.network

import com.example.myapplication.data.model.RepoResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET
    fun getPopularRepo(@Url url: String): Single<RepoResponseModel>
}