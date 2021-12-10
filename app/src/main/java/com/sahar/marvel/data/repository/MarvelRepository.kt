package com.sahar.marvel.data.repository

import android.util.Log
import com.sahar.marvel.data.State
import com.sahar.marvel.data.local.MarvelDatabase
import com.sahar.marvel.data.local.entity.CharacterEntity
import com.sahar.marvel.data.remote.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepository :IMarvelRepository{

    val characterDto = MarvelDatabase.getInstance().marvelCharacterDao()

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

    override fun getCharacter(): Flow<List<CharacterEntity>>{
        return characterDto.getCharacters()
    }

    override suspend fun refreshCharacters() {
        try {
            val response = API.apiService.getCharacters()
            val items = response.body()?.data?.items?.map {
                CharacterEntity(
                    id = it.id?.toLong() ?: 0L,
                    name = it.name ?: "",
                    description = it.description ?: "",
                    modified = it.modified ?: "",
                    imageUrl = "${it.thumbnail?.path}.${it.thumbnail?.extension}"
                )
            }
            items?.let { characterDto.addCharacters(it) }
        }catch (e: Exception){
        }
    }
}