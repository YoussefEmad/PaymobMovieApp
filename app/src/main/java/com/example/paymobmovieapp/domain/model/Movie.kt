package com.example.paymobmovieapp.domain.model

data class Movie(
    val id:Int? = null,
    val moviePoster: String? = null,
    val movieName: String? = null,
    val releaseDate: String? = null,
    val rating: Double? = null,
    val isFavorite: Boolean = false
    )
