package com.example.foodapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.usecase.detail.DetailUseCase
import com.example.core.source.db.remote.Resource
import com.example.core.ui.BaseVM

class DetailFoodVM (private val detailUseCase: DetailUseCase) : BaseVM(){
    private var idFood: String = ""

    fun getId(query : String){
        this.idFood = query
        Log.d("idDetailVM", idFood)
    }

    fun set(): LiveData<Resource<List<FoodDetail>>> {
        Log.d("idDetailVMset", idFood)
        val food : LiveData<Resource<List<FoodDetail>>> =
            detailUseCase.getDetail(idFood).asLiveData()
        return food
    }

    val detail: LiveData<Resource<List<FoodDetail>>> =
        detailUseCase.getDetail(idFood).asLiveData()

    override fun onError(error: Throwable) {

    }
}