package com.example.orderpay.api

import retrofit2.http.GET

interface ApiServiceInterface {
    @GET
    suspend fun getDataFromApi(): ArrayList<Character>
}