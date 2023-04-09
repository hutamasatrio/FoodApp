package com.example.core.utils

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxJava {
    fun <T> applySingleAsync(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}