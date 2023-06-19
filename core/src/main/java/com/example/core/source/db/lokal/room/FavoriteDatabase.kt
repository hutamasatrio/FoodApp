package com.example.core.source.db.lokal.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.source.db.lokal.entity.DetailFoodEntity


@Database(
    entities = [
        DetailFoodEntity::class
    ],
    version = 2,
    exportSchema = false
)

abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
}