package com.example.core.source.repo

import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.FavoriteRepo
import com.example.core.source.db.lokal.room.FavoriteDao
import com.example.core.source.mapper.DetailEntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepository(
    private val favoriteDao : FavoriteDao,
    private val detailEntityMapper: DetailEntityMapper,
): FavoriteRepo {
    override fun getFavorite(): Flow<List<FoodDetail>> =
        favoriteDao.getFavorite().map {
            detailEntityMapper.mapToListDomain(it)
        }

//    override fun setFavoriteFood(food: FoodDetail) {
//        val food = DataMapper.
//        return localDataSource.
//    }


}



//        return favoriteDao.getFavorite().map =
//            detailEntityMapper.mapToListDomain(favoriteDao.getFavorite })
//            val tes : Flow<List<FoodDetail>> = Trans
//            detailEntityMapper.mapToListDomain(it)
//        }
//    detailEntityMapper.mapToListModel(favoriteDao.getFavorite())
//        return favoriteDao.getFavorite()



//}