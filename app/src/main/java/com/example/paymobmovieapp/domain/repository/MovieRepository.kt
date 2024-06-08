package com.example.paymobmovieapp.domain.repository

import com.example.paymobmovieapp.data.source.local.MovieLocal
import com.example.paymobmovieapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieList():List<Movie>
    suspend fun updateFav(isFav: Boolean, id: Int)
     suspend fun getAllMovies(): List<MovieLocal>
     suspend fun insertMovies(movies: List<MovieLocal>):List<Long>

}