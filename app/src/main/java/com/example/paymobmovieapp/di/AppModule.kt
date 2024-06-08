package com.example.paymobmovieapp.di

import android.content.Context
import androidx.room.Room
import com.example.paymobmovieapp.common.NetworkAwareHandler
import com.example.paymobmovieapp.common.NetworkHandlerImpl
import com.example.paymobmovieapp.data.source.local.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MovieDataBase::class.java, "MOVIE_DATABASE_NAME"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieDataBase) = db.getMovieDao()

    @Provides
    @Singleton
    fun provideINetworkAwareHandler( @ApplicationContext context: Context)
            = NetworkHandlerImpl(context) as NetworkAwareHandler

}