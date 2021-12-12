package com.sahar.marvel.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sahar.marvel.data.State
import com.sahar.marvel.data.local.entity.CharacterEntity
import com.sahar.marvel.data.domain.IMarvelRepository
import com.sahar.marvel.data.domain.MarvelRepository
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.ui.base.BaseInteractionListener
import com.sahar.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: IMarvelRepository
) : BaseViewModel() ,CharacterInteractionListener{

    val characters : LiveData<State<List<Character>?>> = repository.getCharacter().asLiveData(Dispatchers.IO)
}