package com.example.paymobmovieapp.data.source.remote.model

import com.example.paymobmovieapp.data.source.local.MovieLocal
import com.example.paymobmovieapp.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title: String? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("media_type") val mediaType: String? = null,
    @SerializedName("genre_ids") val genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = this.id,
        moviePoster = this.posterPath,
        movieName = this.title,
        releaseDate = this.releaseDate,
        rating = this.voteAverage,
        isFavorite = false
    )
}
fun MovieDto.toMovieLocal(): MovieLocal {
    return MovieLocal(
        id = this.id,
        moviePoster = this.posterPath,
        movieName = this.title,
        releaseDate = this.releaseDate,
        rating = this.voteAverage,
        isFavorite = false
    )
}
