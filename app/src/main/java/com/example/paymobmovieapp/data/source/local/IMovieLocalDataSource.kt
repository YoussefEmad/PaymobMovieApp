package com.example.paymobmovieapp.data.source.local

interface IMovieLocalDataSource {
    suspend fun updateFav(isFav :Boolean,id:Int)
     suspend fun getAllMovies():List<MovieLocal>

     suspend fun insertMovies(movies : List<MovieLocal>):List<Long>



}