package com.sahar.marvel.model.repository

import com.sahar.marvel.model.State
import com.sahar.marvel.model.remote.response.characters.Characters
import com.sahar.marvel.model.remote.response.characters.Result
import kotlinx.coroutines.flow.Flow

interface IMarvelRepository {
    fun getCharacter(): Flow<State<Characters<Result>?>>
}