package com.sahar.marvel.data.domain

import com.sahar.marvel.data.State
import com.sahar.marvel.data.domain.mapper.CharacterDtoToCharacter
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.data.remote.MarvelService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val apiService : MarvelService,
    private val characterMapper : CharacterDtoToCharacter
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

}