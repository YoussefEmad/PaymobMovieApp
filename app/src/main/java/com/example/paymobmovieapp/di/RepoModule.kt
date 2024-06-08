package com.example.paymobmovieapp.di

import com.example.paymobmovieapp.data.repository.MovieRepositoryImpl
import com.example.paymobmovieapp.data.source.remote.IMovieRemoteDatasource
import com.example.paymobmovieapp.data.source.remote.MovieApiService
import com.example.paymobmovieapp.data.source.remote.MoviesRemoteDataSource
import com.example.paymobmovieapp.domain.repository.MovieRepository
import com.example.paymobmovieapp.domain.usecase.GetMoviesUseCase
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
        moviesRemoteDataSource: IMovieRemoteDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(moviesRemoteDataSource)
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
    fun provideIOnlineDataSource(
        service: MovieApiService
    ): IMovieRemoteDatasource {
        return MoviesRemoteDataSource(service)
    }
}
