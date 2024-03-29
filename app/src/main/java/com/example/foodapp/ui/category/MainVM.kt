package com.example.foodapp.ui.category

import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.category.CategoryUseCase
import com.example.core.ui.BaseVM

class MainVM(
    categoryUseCase: CategoryUseCase
) : BaseVM() {

    val category = categoryUseCase.getCategory().asLiveData()


}