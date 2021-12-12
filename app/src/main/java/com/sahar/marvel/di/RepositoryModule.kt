package com.sahar.marvel.di

import com.sahar.marvel.data.domain.IMarvelRepository
import com.sahar.marvel.data.domain.MarvelRepository
import com.sahar.marvel.data.domain.mapper.CharacterDtoToCharacter
import com.sahar.marvel.data.remote.MarvelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(characterMapper : CharacterDtoToCharacter,apiService : MarvelService,
    ): IMarvelRepository{
        return MarvelRepository(apiService,characterMapper)
    }

    @Provides
    fun provideCharacterMapper(): CharacterDtoToCharacter = CharacterDtoToCharacter()
}