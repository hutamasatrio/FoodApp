package com.example.foodapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.usecase.detail.DetailUseCase
import com.example.core.source.db.remote.Resource
import com.example.core.source.mapper.DetailEntityMapper
import com.example.core.ui.BaseVM
import kotlinx.coroutines.flow.map

class DetailFoodVM(private val detailUseCase: DetailUseCase) : BaseVM() {
    private val detailEntityMapper = DetailEntityMapper()

    private var idFood: String = ""

    fun getId(query: String) {
        this.idFood = query
    }

    fun set(): LiveData<Resource<List<FoodDetail>>> = detailUseCase.getDetail(idFood).asLiveData()


    fun saveFav(food: FoodDetail) = detailUseCase.favFood(food)


    fun cekFav(): LiveData<List<FoodDetail>> {
        val foodRaw = detailUseCase.cekFav(idFood)
        val food = foodRaw.map{
            detailUseCase.mapper(it)
        }
        return food.asLiveData()

    }

    fun cekFav1(): LiveData<FoodDetail> {
        val foodRaw = detailUseCase.cekFav(idFood)
        val food = foodRaw.map {
            detailEntityMapper.mapToListDomain(it)
        }
        val v = food.map {
            it[0]
        }
        return v.asLiveData()
    }


    fun deleteFood(id: String) = detailUseCase.deleteFood(id)


    val detail: LiveData<Resource<List<FoodDetail>>> =
        detailUseCase.getDetail(idFood).asLiveData()


}