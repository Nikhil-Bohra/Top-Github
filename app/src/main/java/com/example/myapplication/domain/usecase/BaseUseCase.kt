package com.example.myapplication.domain.usecase

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase<T, Params> {

    abstract fun getUseCaseObservable(params: Params):Single<T>
    private val compositeDisposable = CompositeDisposable()

    fun execute(observer: DisposableSingleObserver<T>, params: Params){
        compositeDisposable.add(getUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer))
    }

    fun dispose(){
        if(!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }

}