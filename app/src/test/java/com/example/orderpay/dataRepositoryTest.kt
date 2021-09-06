package com.example.orderpay

import com.example.orderpay.api.ApiServiceInterface
import com.example.orderpay.data.DataRepository
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class dataRepositoryTest {
    @Mock
    private lateinit var apiServiceInterface: ApiServiceInterface

    @InjectMocks
    private lateinit var dataRepository: DataRepository

    @Test
    fun getCharacters() {
        runBlockingTest {
            dataRepository.fetchCharacters()
            verify(apiServiceInterface, times(1)).getCharacters()
        }
    }
}