package com.example.paymobmovieapp.data.source.local

interface IMovieLocalDataSource {
    suspend fun updateFav(isFav :Boolean,id:Int)


}