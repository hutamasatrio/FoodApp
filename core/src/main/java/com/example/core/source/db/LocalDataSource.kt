package com.example.core.source.db

import androidx.lifecycle.LiveData
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.core.source.db.lokal.room.FavoriteDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource (private val favoriteDao : FavoriteDao ) {
    fun getFavorite(): LiveData<List<DetailFoodEntity>> = favoriteDao.getFavorite()

    //private fun getDetailUser(username: String): Flow<UserEntity> = userDao.getDetailUser(username)
//
//    fun getDetailState(username: String): Flow<UserEntity>? = userDao.getDetailState(username)
//
//    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)
//
//    suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)
}