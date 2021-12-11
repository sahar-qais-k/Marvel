package com.sahar.marvel.data.domain

import com.sahar.marvel.data.State
import com.sahar.marvel.data.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface IMarvelRepository {
    fun getCharacter(): Flow<State<List<Character>?>>

//    suspend fun refreshCharacters()
}