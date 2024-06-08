package com.example.paymobmovieapp.domain.usecase

import com.example.paymobmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun getMovies() = movieRepository.getMovieList()
}
