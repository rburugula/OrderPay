package com.example.orderpay

import androidx.lifecycle.Observer
import com.example.orderpay.data.DataRepository
import com.example.orderpay.model.Character
import com.example.orderpay.viewModel.MainActivityViewModel
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {
    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var dataObserver: Observer<Result<List<Character>>>

    @InjectMocks
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @ExperimentalCoroutinesApi
    @Test
    fun fetchCharacters() {
        runBlockingTest {
            mainActivityViewModel.fetchCharacters()
            verify(dataRepository).fetchCharacters()
        }
    }
}