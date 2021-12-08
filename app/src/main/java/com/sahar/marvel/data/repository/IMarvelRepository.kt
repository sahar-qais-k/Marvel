package com.sahar.marvel.data.repository

import com.sahar.marvel.data.State
import com.sahar.marvel.data.remote.response.characters.BaseResponse
import com.sahar.marvel.data.remote.response.characters.CharacterDto
import kotlinx.coroutines.flow.Flow

interface IMarvelRepository {
    fun getCharacter(): Flow<State<BaseResponse<CharacterDto>?>>

    suspend fun refreshCharacters()
}