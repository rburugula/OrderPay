package com.example.orderpay.api

import com.example.orderpay.model.Character
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("api/characters")
    suspend fun getCharacters(): ArrayList<Character>
}