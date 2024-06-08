package com.example.paymobmovieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Movie(
    val id:Int,
    val moviePoster: String? = null,
    val movieName: String? = null,
    val releaseDate: String? = null,
    val rating: Double? = null,
    var isFavorite: Boolean = false,
    val overview : String ?= null,
    val originalTitle: String ?=null
    ): Parcelable

