package com.example.paymobmovieapp.domain.usecase

import com.example.paymobmovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    suspend fun updateMovie(isFav: Boolean, id: Int) = movieRepository.updateFav(isFav, id)
}
