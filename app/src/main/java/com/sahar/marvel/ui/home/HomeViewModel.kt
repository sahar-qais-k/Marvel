package com.sahar.marvel.ui.base.home

import androidx.lifecycle.asLiveData
import com.sahar.marvel.data.repository.MarvelRepository
import com.sahar.marvel.ui.base.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    val characters = MarvelRepository.getCharacter().asLiveData()




}