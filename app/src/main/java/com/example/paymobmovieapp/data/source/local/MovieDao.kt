package com.example.paymobmovieapp.data.source.local

import androidx.room.Dao
import androidx.room.Query


@Dao
interface MovieDao {
    @Query("UPDATE MovieLocal SET isFavorite = :isFv  WHERE id = :id")
    suspend fun updateFav(isFv: Boolean, id: Int)
}