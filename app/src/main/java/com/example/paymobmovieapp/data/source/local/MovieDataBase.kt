package com.example.paymobmovieapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieLocal::class], version = 0 , exportSchema = false)

abstract class MovieDataBase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}

