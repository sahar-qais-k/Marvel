package com.sahar.marvel.data.domain

import com.sahar.marvel.data.State
import com.sahar.marvel.data.domain.mapper.CharacterDtoToCharacter
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.data.local.MarvelDatabase
import com.sahar.marvel.data.local.entity.SearchEntity
import com.sahar.marvel.data.remote.MarvelService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val apiService : MarvelService,
    private val characterMapper : CharacterDtoToCharacter,
    private val marvelDatabase: MarvelDatabase,

    ) :IMarvelRepository{


    override fun getCharacter(): Flow<State<List<Character>?>>{
        return flow {
            emit(State.Loading)
            try {
                val characters = apiService.getCharacters().body()?.data?.items?.map { characterDto ->
                    characterMapper.map(characterDto)
                }
                emit(State.Success(characters))
            }catch (throwable: Throwable){
                emit(State.Error(throwable))
            }
        }
    }

    override fun search(name: String): Flow<State<List<Character>?>> = wrap { getAllCharacterSearch(name) }


    private suspend fun getAllCharacterSearch(name: String): List<Character> {
        suspend fun result() = searchInDB("%$name%")
        if (result().isEmpty()) {
            refreshDataSearch(name)
        }
        return result().map {
            characterMapper.searchMapper.mapToCharacter(it)
        }
    }
    private suspend fun searchInDB(query: String): List<SearchEntity> =
        marvelDatabase.searchDao.searchInDB(query)

    private fun <T> wrap(function: suspend () -> T): Flow<State<T?>> =
        flow {
            try {
                emit(State.Loading)
                emit(State.Success(function()))
            } catch (throwable: Throwable) {
                emit(State.Error(throwable))
            }
        }

}