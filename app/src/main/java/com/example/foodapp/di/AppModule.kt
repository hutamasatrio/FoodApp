package com.example.foodapp.di

import com.example.core.domain.usecase.category.CategoryInteractor
import com.example.core.domain.usecase.category.CategoryUseCase
import com.example.core.domain.usecase.food.FoodInteractor
import com.example.core.domain.usecase.food.FoodUseCase
import com.example.foodapp.ui.category.MainVM
import com.example.foodapp.ui.food.FoodVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory <CategoryUseCase>{ CategoryInteractor(get()) }
    factory <FoodUseCase>{ FoodInteractor(get()) }
}
val viewModelModule = module {
    viewModel { MainVM(get()) }
    viewModel { FoodVM(get()) }

}