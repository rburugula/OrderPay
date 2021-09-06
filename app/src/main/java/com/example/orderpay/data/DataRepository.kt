package com.example.orderpay.data

import com.example.orderpay.api.ApiServiceInterface
import com.example.orderpay.model.Character
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiServiceInterface: ApiServiceInterface
) {
    suspend fun fetchCharacters(): Result<ArrayList<Character>> = kotlin.runCatching {
        apiServiceInterface.getCharacters()
    }
}