package com.example.paymobmovieapp.data.repository

import com.example.paymobmovieapp.common.NetworkAwareHandler
import com.example.paymobmovieapp.data.source.local.IMovieLocalDataSource
import com.example.paymobmovieapp.data.source.local.MovieLocal
import com.example.paymobmovieapp.data.source.local.toMovie
import com.example.paymobmovieapp.data.source.local.toMovieLocalList
import com.example.paymobmovieapp.data.source.remote.IMovieRemoteDatasource
import com.example.paymobmovieapp.data.source.remote.model.toMovie
import com.example.paymobmovieapp.domain.model.Movie
import com.example.paymobmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: IMovieRemoteDatasource,
    private val moviesLocalDataSource: IMovieLocalDataSource,
    private val networkHandler: NetworkAwareHandler
) : MovieRepository {

    override suspend fun getMovieList(): List<Movie> {
        val moviesList = moviesRemoteDataSource.getMovies().results.map {
            it.toMovie()
        }
        val movieLocal = moviesList.toMovieLocalList()
        return if (networkHandler.isOnline()) {
            insertMovies(movieLocal)
            getAllMovies().map { it.toMovie() }
        } else {
            getAllMovies().map { it.toMovie() }
        }
    }

    override suspend fun updateFav(isFav: Boolean, id: Int) {
        moviesLocalDataSource.updateFav(isFav, id)
    }

    override suspend fun getAllMovies() = moviesLocalDataSource.getAllMovies()


    override suspend fun insertMovies(movies: List<MovieLocal>) =
        moviesLocalDataSource.insertMovies(movies)
}