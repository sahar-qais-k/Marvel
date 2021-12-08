package com.sahar.marvel.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sahar.marvel.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharactersDao {
    @Insert
    suspend fun addCharacters(item: List<CharacterEntity>)
    @Query("Select * from CharacterEntity")
    fun getCharacters(): Flow<List<CharacterEntity>>
}