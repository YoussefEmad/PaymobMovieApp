package com.example.paymobmovieapp.data.source.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paymobmovieapp.data.source.remote.model.MovieDto
import com.example.paymobmovieapp.domain.model.Movie

@Entity
data class MovieLocal (
    @PrimaryKey
    @NonNull
    val id:Int,
    val moviePoster: String? = null,
    val movieName: String? = null,
    val releaseDate: String? = null,
    val rating: Double? = null,
    val isFavorite: Boolean = false
)
fun MovieLocal.toMovie(): Movie {
    return Movie(
        id = this.id,
        moviePoster = this.moviePoster,
        movieName = this.movieName,
        releaseDate = this.releaseDate,
        rating = this.rating,
        isFavorite = this.isFavorite
    )
}
fun List<Movie>.toMovieLocalList(): List<MovieLocal> {
    return this.map { movie ->
        MovieLocal(
            id = movie.id,
            moviePoster = movie.moviePoster,
            movieName = movie.movieName,
            releaseDate = movie.releaseDate,
            rating = movie.rating,
            isFavorite = movie.isFavorite
        )
    }
}
