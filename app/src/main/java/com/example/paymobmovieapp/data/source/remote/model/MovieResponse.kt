package com.example.paymobmovieapp.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<MovieDto> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
)