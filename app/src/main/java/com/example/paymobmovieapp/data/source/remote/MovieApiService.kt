package com.example.paymobmovieapp.data.source.remote

import com.example.paymobmovieapp.data.source.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("primary_release_year") year: Int,
    ): MovieResponse
}
