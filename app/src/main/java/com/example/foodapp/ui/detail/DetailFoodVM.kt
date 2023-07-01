package com.example.foodapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.usecase.detail.DetailUseCase
import com.example.core.source.db.lokal.entity.DetailFoodEntity
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

    fun saveFav(food : FoodDetail){
        detailUseCase.favFood(food)
    }

    fun cekFav(): LiveData<List<DetailFoodEntity>> {
        return detailUseCase.cekFav(idFood).asLiveData()
    }


    fun deleteFood(id: String){
        detailUseCase.deleteFood(id)
    }

    val detail: LiveData<Resource<List<FoodDetail>>> =
        detailUseCase.getDetail(idFood).asLiveData()


}