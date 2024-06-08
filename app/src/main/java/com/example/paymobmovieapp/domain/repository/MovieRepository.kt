package com.example.paymobmovieapp.domain.repository

import com.example.paymobmovieapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieList():List<Movie>
}