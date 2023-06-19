package com.example.foodapp.di

import com.example.core.domain.usecase.category.CategoryInteractor
import com.example.core.domain.usecase.category.CategoryUseCase
import com.example.core.domain.usecase.detail.DetailInteractor
import com.example.core.domain.usecase.detail.DetailUseCase
import com.example.core.domain.usecase.favorite.FavoriteInteractor
import com.example.core.domain.usecase.favorite.FavoriteUseCase
import com.example.core.domain.usecase.food.FoodInteractor
import com.example.core.domain.usecase.food.FoodUseCase
import com.example.foodapp.ui.category.MainVM
import com.example.foodapp.ui.detail.DetailFoodVM
import com.example.foodapp.ui.food.FoodVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val useCaseModule = module {
    factory <CategoryUseCase>{ CategoryInteractor(get()) }
    factory <FoodUseCase>{ FoodInteractor(get()) }
    factory <DetailUseCase>{ DetailInteractor(get()) }
    factory <FavoriteUseCase>{ FavoriteInteractor(get()) }


}
val viewModelModule = module {
    viewModel { MainVM(get()) }
    viewModel { FoodVM(get()) }
    viewModel { DetailFoodVM(get()) }

}