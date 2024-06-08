package com.example.paymobmovieapp.domain.model

data class Movie(
    val id:Int,
    val moviePoster: String? = null,
    val movieName: String? = null,
    val releaseDate: String? = null,
    val rating: Double? = null,
    var isFavorite: Boolean = false
    )
