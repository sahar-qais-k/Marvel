package com.sahar.marvel.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.sahar.marvel.data.State
import com.sahar.marvel.data.domain.IMarvelRepository
import com.sahar.marvel.data.domain.models.Character
import com.sahar.marvel.ui.base.BaseInteractionListener
import com.sahar.marvel.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val repository: IMarvelRepository
    ): BaseViewModel(),BaseInteractionListener {
    var characterSearch: MutableStateFlow<String?> = MutableStateFlow("")


    var character = characterSearch.debounce(1500).map {
        characterSearch(it ?: "")
    }.asLiveData()


    private fun characterSearch(query: String): LiveData<State<List<Character>?>> =
        repository.search(query).asLiveData()

}