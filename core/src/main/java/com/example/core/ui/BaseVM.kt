package com.example.core.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseVM : ViewModel(){

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    abstract fun onError(error: Throwable)

}