package com.example.myapplication.presentation.view.ui.main

import com.example.myapplication.data.model.RepositoryData

interface MainCallback {

    fun onReceiveSuccess(repositoryDataList: ArrayList<RepositoryData>)

    fun onReceiveError(error : Throwable)
}