package com.example.paymobmovieapp.data.repository

import com.example.paymobmovieapp.data.source.local.IMovieLocalDataSource
import com.example.paymobmovieapp.data.source.local.MoviesLocalDataSource
import com.example.paymobmovieapp.data.source.remote.model.MovieResponse
import com.example.paymobmovieapp.data.source.remote.model.toDto
import com.example.paymobmovieapp.data.source.remote.IMovieRemoteDatasource
import com.example.paymobmovieapp.domain.model.Movie
import com.example.paymobmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val moviesRemoteDataSource: IMovieRemoteDatasource,
    private val moviesLocalDataSource: IMovieLocalDataSource):MovieRepository  {

    override suspend fun getMovieList(): List<Movie> {
        return moviesRemoteDataSource.getMovies().results.map {
            it.toDto()
        }
    }

    override suspend fun updateFav(isFav: Boolean, id: Int) {
        moviesLocalDataSource.updateFav(isFav,id)
    }
}