package com.example.core.source.repo

import android.service.autofill.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.domain.repository.FavoriteRepo
import com.example.core.source.db.LocalDataSource
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.core.source.db.lokal.room.FavoriteDao
import com.example.core.source.mapper.DetailEntityMapper
import kotlinx.coroutines.flow.*

class FavoriteRepository(
    private val favoriteDao : FavoriteDao,
    private val localDataSource: LocalDataSource,
    private val detailEntityMapper: DetailEntityMapper
): FavoriteRepo {
    override fun getFavorite(): LiveData<List<FoodDetail>> =


        favoriteDao.getFavorite().map {
            detailEntityMapper.mapToListDomain(it)

        }




}



//        return favoriteDao.getFavorite().map =
//            detailEntityMapper.mapToListDomain(favoriteDao.getFavorite })
//            val tes : Flow<List<FoodDetail>> = Trans
//            detailEntityMapper.mapToListDomain(it)
//        }
//    detailEntityMapper.mapToListModel(favoriteDao.getFavorite())
//        return favoriteDao.getFavorite()



//}