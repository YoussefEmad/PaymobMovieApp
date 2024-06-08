package com.example.paymobmovieapp.data.repository

import com.example.paymobmovieapp.data.model.MovieResponse
import com.example.paymobmovieapp.data.model.toDto
import com.example.paymobmovieapp.data.source.remote.IMovieRemoteDatasource
import com.example.paymobmovieapp.domain.model.Movie
import com.example.paymobmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val moviesRemoteDataSource: IMovieRemoteDatasource):MovieRepository  {
    override suspend fun getMovieList(): List<Movie> {
        return moviesRemoteDataSource.getMovies().results.map {
            it.toDto()
        }
    }
}