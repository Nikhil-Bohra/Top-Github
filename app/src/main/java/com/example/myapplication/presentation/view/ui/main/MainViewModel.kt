package com.example.myapplication.presentation.view.ui.main

import com.example.myapplication.data.model.RepoResponseModel
import com.example.myapplication.domain.usecase.RepoUseCase
import com.example.myapplication.presentation.view.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject


class MainViewModel @Inject constructor(var repoUseCase: RepoUseCase) :
    BaseViewModel<MainCallback>() {


    fun getRepositoryDetails() {
        val url = "repo?lang=java&since=weekly"
        repoUseCase.execute(object : DisposableSingleObserver<RepoResponseModel>() {
            override fun onSuccess(repoResponseModel: RepoResponseModel) {
                callback?.onReceiveSuccess(repoResponseModel.repositoryData)
            }

            override fun onError(e: Throwable) {
                callback?.onReceiveError(e)
            }

        }, RepoUseCase.Params(url))
    }
}