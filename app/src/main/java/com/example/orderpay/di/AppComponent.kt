package com.example.orderpay.di

import com.example.orderpay.CharactersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface AppComponent {
    fun inject(charactersFragment: CharactersFragment)
}