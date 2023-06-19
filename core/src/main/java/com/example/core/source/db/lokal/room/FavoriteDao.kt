package com.example.core.source.db.lokal.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bumptech.glide.load.engine.Resource
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(food: DetailFoodEntity)

    @Query("DELETE from detailFood where idMeal=:id ")
    fun removeFood(id: String)

    @Query("SELECT * FROM detailFood WHERE idMeal=:idMeals")
    fun  getFavoriteFoodsById(idMeals: String) : LiveData<List<DetailFoodEntity>>

    @Query("SELECT * FROM detailFood ORDER BY idMeal ASC")
    fun getFavorite() : LiveData<List<DetailFoodEntity>>
}