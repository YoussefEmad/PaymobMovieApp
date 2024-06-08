package com.example.paymobmovieapp.data.source.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

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