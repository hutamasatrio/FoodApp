package com.example.foodapp.ui.food


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.core.domain.model.Food
import com.example.core.domain.usecase.food.FoodUseCase
import com.example.core.source.db.remote.Resource
import com.example.core.ui.BaseVM

class FoodVM(
    private val foodUseCase: FoodUseCase
) : BaseVM() {
    //private var idCategory : MutableLiveData<String> = MutableLiveData()tr
    private var idCategory: String = ""


    fun getId(query: String) {
        this.idCategory = query
        Log.d("idCategoryVM", idCategory)
    }


    fun set(): LiveData<Resource<List<Food>>> {
        Log.d("idCategoryVMset", idCategory)

        val food: LiveData<Resource<List<Food>>> =
            foodUseCase.getAllFood(idCategory).asLiveData()
        return food
    }

    val food: LiveData<Resource<List<Food>>> =
        foodUseCase.getAllFood(idCategory).asLiveData()


}