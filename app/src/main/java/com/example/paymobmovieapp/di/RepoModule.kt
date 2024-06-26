package com.example.paymobmovieapp.di

import com.example.paymobmovieapp.common.NetworkAwareHandler
import com.example.paymobmovieapp.data.repository.MovieRepositoryImpl
import com.example.paymobmovieapp.data.source.local.IMovieLocalDataSource
import com.example.paymobmovieapp.data.source.local.MovieDao
import com.example.paymobmovieapp.data.source.local.MoviesLocalDataSource
import com.example.paymobmovieapp.data.source.remote.IMovieRemoteDatasource
import com.example.paymobmovieapp.data.source.remote.MovieApiService
import com.example.paymobmovieapp.data.source.remote.MoviesRemoteDataSource
import com.example.paymobmovieapp.domain.repository.MovieRepository
import com.example.paymobmovieapp.domain.usecase.GetMoviesUseCase
import com.example.paymobmovieapp.domain.usecase.UpdateMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        moviesRemoteDataSource: IMovieRemoteDatasource,
        movieLocalDataSource: IMovieLocalDataSource,
        networkAwareHandler: NetworkAwareHandler
    ): MovieRepository {
        return MovieRepositoryImpl(moviesRemoteDataSource,movieLocalDataSource,networkAwareHandler)
    }

    @Provides
    @Singleton
    fun provideGetMovieUseCase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        service: MovieApiService
    ): IMovieRemoteDatasource {
        return MoviesRemoteDataSource(service)
    }

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(
        movieDao: MovieDao
    ): IMovieLocalDataSource {
        return MoviesLocalDataSource(movieDao)
    }
    @Provides
    @Singleton
    fun provideUpdateMovieUseCase(
        movieRepository: MovieRepository
    ): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
}
