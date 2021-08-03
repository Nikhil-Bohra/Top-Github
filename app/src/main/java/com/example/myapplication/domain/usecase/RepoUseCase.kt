package com.example.myapplication.domain.usecase

import com.example.myapplication.data.model.RepoResponseModel
import com.example.myapplication.domain.repository.AppRepository
import io.reactivex.Single
import javax.inject.Inject

class RepoUseCase @Inject constructor(val appRepository: AppRepository) :
    BaseUseCase<RepoResponseModel, RepoUseCase.Params>() {

    override fun getUseCaseObservable(params: Params): Single<RepoResponseModel> {
        return appRepository.getRepositoryData(params.url)
    }

    open class Params(val url: String) {
    }
}

