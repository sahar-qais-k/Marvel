package com.sahar.marvel.ui.base.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.sahar.marvel.model.State
import com.sahar.marvel.model.remote.response.characters.Characters
import com.sahar.marvel.model.remote.response.characters.Result
import com.sahar.marvel.model.repository.MarvelRepository
import com.sahar.marvel.ui.base.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    val characters = MarvelRepository.getCharacter().asLiveData()




}