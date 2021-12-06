package com.sahar.marvel.ui.base.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahar.marvel.model.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> collectValue(repoValue: Flow<State<T?>>, liveValue: MutableLiveData<State<T?>>) {
        viewModelScope.launch {
            repoValue
                .catch { }
                .collect { liveValue.value = it }
        }
    }

}