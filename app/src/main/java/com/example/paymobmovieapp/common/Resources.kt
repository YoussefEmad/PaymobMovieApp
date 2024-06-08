package com.example.paymobmovieapp.common

    sealed class ViewState<T>(
        val data: List<T>? = null,
        val msg: String? = null
    ) {
        class Success<T>(data: List<T>) : ViewState<T>(data)
        class Error<T>(msg: String?, data: List<T>? = null) : ViewState<T>(data, msg)
        class Loading<T> : ViewState<T>()
    }
