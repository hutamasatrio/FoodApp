package com.example.foodapp.ui.Category

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.model.Category
import com.example.core.domain.usecase.CategoryUseCase
import com.example.core.ui.BaseVM
import com.example.core.utils.RxJava
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainVM (
    private val categoryUseCase: CategoryUseCase
        ): BaseVM(){
    val postData =  MutableLiveData<List<Category>>()
    val progressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getCategory(){
        progressbar.value = true
        compositeDisposable.add(
            categoryUseCase.getCategory()
                .subscribe({result ->
                    postData.value = result
                    progressbar.value = false
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        if (error.message != null) messageData.value = error.message
    }
}