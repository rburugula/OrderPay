package com.example.orderpay.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orderpay.data.DataRepository
import com.example.orderpay.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel() {

    val _charactersLiveData = MutableLiveData<Result<ArrayList<Character>>>()
    val charactersLiveData: LiveData<Result<ArrayList<Character>>> = _charactersLiveData

    fun fetchCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            _charactersLiveData.postValue(dataRepository.fetchCharacters())
        }
    }
}