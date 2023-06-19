package com.example.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import com.example.core.domain.usecase.favorite.FavoriteUseCase
import com.example.core.ui.BaseVM

class FavoriteVM(favoriteUseCase: FavoriteUseCase) : BaseVM() {
    val getFavoriteMeals = favoriteUseCase.getFavorite()


    override fun onError(error: Throwable) {
        TODO("Not yet implemented")
    }

}