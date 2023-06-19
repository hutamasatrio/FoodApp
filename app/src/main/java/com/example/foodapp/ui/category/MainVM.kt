package com.example.foodapp.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.category.CategoryUseCase
import com.example.core.ui.BaseVM

class MainVM (
    private val categoryUseCase: CategoryUseCase
        ): BaseVM(){

    val messageData = MutableLiveData<String>()
    val category = categoryUseCase.getCategory().asLiveData()


    override fun onError(error: Throwable) {
        if (error.message != null) messageData.value = error.message
    }
}