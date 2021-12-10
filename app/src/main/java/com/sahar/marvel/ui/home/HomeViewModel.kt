package com.sahar.marvel.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sahar.marvel.data.local.entity.CharacterEntity
import com.sahar.marvel.data.repository.IMarvelRepository
import com.sahar.marvel.data.repository.MarvelRepository
import com.sahar.marvel.ui.base.BaseInteractionListener
import com.sahar.marvel.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() ,BaseInteractionListener{
    private val repository: IMarvelRepository = MarvelRepository()
    val characters : LiveData<List<CharacterEntity>> = repository.getCharacter().asLiveData(Dispatchers.IO)
    init {
        viewModelScope.launch {
            repository.refreshCharacters()
        }
    }
}