package com.example.paymobmovieapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymobmovieapp.common.ViewState
import com.example.paymobmovieapp.domain.model.Movie
import com.example.paymobmovieapp.domain.usecase.GetMoviesUseCase
import com.example.paymobmovieapp.domain.usecase.UpdateMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {

    private val _movieLiveData: MutableLiveData<ViewState<Movie>> = MutableLiveData()
    val movieLiveData get() = _movieLiveData

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch(IO) {
            _movieLiveData.postValue(ViewState.Loading())
            try {
                val movies = getMoviesUseCase.getMovies()
                _movieLiveData.postValue(ViewState.Success(movies))
            } catch (e: Exception) {
                _movieLiveData.postValue(ViewState.Error(e.localizedMessage))

            }
        }
    }
    fun updateFav(isFav : Boolean, id :Int){
        viewModelScope.launch(IO) {
            updateMovieUseCase.updateMovie(isFav, id)
        }
    }
}
