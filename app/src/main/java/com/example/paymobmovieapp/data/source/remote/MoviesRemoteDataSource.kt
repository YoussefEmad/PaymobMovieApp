package com.example.paymobmovieapp.data.source.remote

import com.example.paymobmovieapp.data.source.remote.model.MovieResponse
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(private val service: MovieApiService) : IMovieRemoteDatasource{
    override suspend fun getMovies(): MovieResponse {
        return service.getMovies(2024)
    }
}