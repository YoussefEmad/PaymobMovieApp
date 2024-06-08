package com.example.paymobmovieapp.data.source.local

import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(private val movieDao: MovieDao): IMovieLocalDataSource{
    override suspend fun updateFav(isFav: Boolean, id: Int) {
        movieDao.updateFav(isFav,id)
    }
}