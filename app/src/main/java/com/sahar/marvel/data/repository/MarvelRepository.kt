package com.sahar.marvel.data.repository

import com.sahar.marvel.data.State
import com.sahar.marvel.data.remote.API
import com.sahar.marvel.data.remote.response.characters.BaseResponse
import com.sahar.marvel.data.remote.response.characters.CharacterDto
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

    override fun getCharacter(): Flow<State<BaseResponse<CharacterDto>?>> {
        return wrapWithFlow {
            API.apiService.getCharacters()
        }
    }

    override suspend fun refreshCharacters() {

    }
}