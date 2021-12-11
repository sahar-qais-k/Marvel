package com.sahar.marvel.data.domain

import com.sahar.marvel.data.State
import com.sahar.marvel.data.domain.mapper.CharacterDtoToCharacter
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.data.remote.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarvelRepository :IMarvelRepository{

    private val characterMapper = CharacterDtoToCharacter()

//    private fun <T> wrapWithFlow(function : suspend () -> Response<T>) : Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val result = function()
//                if (result.isSuccessful){
//                    emit(State.Success(result.body()))
//                } else {
//                    emit(State.Error(result.message()))
//                }
//            } catch (e:Exception){
//                emit(State.Error(e.message.toString()))
//            }
//        }
//    }

    override fun getCharacter(): Flow<State<List<Character>?>>{
        return flow {
            emit(State.Loading)
            try {
                val characters =API.apiService.getCharacters().body()?.data?.items?.map { characterDto ->
                    characterMapper.map(characterDto)
                }
                emit(State.Success(characters))
            }catch (throwable: Throwable){
                emit(State.Error(throwable))
            }
        }
    }

//    override suspend fun refreshCharacters() {
//        try {
//            val response = API.apiService.getCharacters()
//            val items = response.body()?.data?.items?.map {
//                CharacterEntity(
//                    id = it.id?.toLong() ?: 0L,
//                    name = it.name ?: "",
//                    description = it.description ?: "",
//                    modified = it.modified ?: "",
//                    imageUrl = "${it.thumbnail?.path}.${it.thumbnail?.extension}"
//                )
//            }
//            items?.let { characterDto.addCharacters(it) }
//        }catch (e: Exception){
//        }
//    }
}