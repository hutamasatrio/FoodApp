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

    @Query("SELECT * FROM detailFood ORDER BY idMeal ASC")
    fun getFavorite() : Flow<List<DetailFoodEntity>>

    @Query("DELETE from detailFood where idMeal=:id ")
    fun deleteFood(id: String)

    @Query("SELECT * from detailFood WHERE idMeal=:idMeals")
    fun  cekFavorite(idMeals: String) : LiveData<List<DetailFoodEntity>>


}