package com.example.foodapp.di

import com.example.core.domain.usecase.CategoryInteractor
import com.example.core.domain.usecase.CategoryUseCase
import com.example.foodapp.ui.Category.MainVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory <CategoryUseCase>{ CategoryInteractor(get()) }
}
val viewModelModule = module {
    viewModel { MainVM(get()) }
}