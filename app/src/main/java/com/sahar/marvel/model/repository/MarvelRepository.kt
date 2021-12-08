package com.sahar.marvel.model.repository

import com.sahar.marvel.model.State
import com.sahar.marvel.model.remote.API
import com.sahar.marvel.model.remote.response.characters.Characters
import com.sahar.marvel.model.remote.response.characters.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object MarvelRepository :IMarvelRepository{

    private fun <T> wrapWithFlow(function : suspend () -> Response<T>) : Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful){
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e:Exception){
                emit(State.Error(e.message.toString()))
            }
        }
    }

    override fun getCharacter(): Flow<State<Characters<Result>?>> {
        return wrapWithFlow {
            API.apiService.getCharacters()
        }
    }
}