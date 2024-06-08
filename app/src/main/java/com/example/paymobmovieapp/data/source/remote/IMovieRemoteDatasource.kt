package com.example.paymobmovieapp.data.source.remote

import com.example.paymobmovieapp.data.model.MovieResponse

interface IMovieRemoteDatasource{
    suspend fun getMovies(): MovieResponse
}