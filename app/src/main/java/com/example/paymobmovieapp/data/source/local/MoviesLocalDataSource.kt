package com.example.paymobmovieapp.data.source.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(private val movieDao: MovieDao) :
    IMovieLocalDataSource {
    override suspend fun updateFav(isFav: Boolean, id: Int) {
        movieDao.updateFav(isFav, id)
    }

    override suspend fun getAllMovies(): List<MovieLocal> =
        movieDao.getAllMovies()

    override suspend fun insertMovies(movies: List<MovieLocal>) = movieDao.insertMovies(movies)

}