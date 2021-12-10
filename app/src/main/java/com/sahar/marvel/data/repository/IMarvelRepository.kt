package com.sahar.marvel.data.repository

import com.sahar.marvel.data.State
import com.sahar.marvel.data.local.entity.CharacterEntity
import com.sahar.marvel.data.remote.response.characters.BaseResponse
import com.sahar.marvel.data.remote.response.characters.CharacterDto
import kotlinx.coroutines.flow.Flow

interface IMarvelRepository {
    fun getCharacter(): Flow<List<CharacterEntity>>

    suspend fun refreshCharacters()
}