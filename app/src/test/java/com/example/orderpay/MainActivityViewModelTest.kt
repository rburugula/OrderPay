package com.example.orderpay

import com.example.orderpay.data.DataRepository
import com.example.orderpay.viewModel.MainActivityViewModel
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {
    @Mock
    private lateinit var dataRepository: DataRepository

    @InjectMocks
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Test
    fun fetchCharacters() {
        runBlockingTest {
            mainActivityViewModel.fetchCharacters()
            verify(dataRepository).fetchCharacters()
        }
    }
}