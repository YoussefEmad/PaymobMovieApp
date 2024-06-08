package com.example.paymobmovieapp.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movies: List<MovieLocal>): List<Long>
    @Query("SELECT * FROM  MovieLocal")
    suspend fun getAllMovies(): List<MovieLocal>
    @Query("UPDATE MovieLocal SET isFavorite = :isFv  WHERE id = :id")
    suspend fun updateFav(isFv: Boolean, id: Int)
}