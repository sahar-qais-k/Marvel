package com.sahar.marvel.data

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error(val message: Throwable) : State<Nothing>()
    object Loading : State<Nothing>()

    fun toData() : T? = if (this is Success) data else null
}
