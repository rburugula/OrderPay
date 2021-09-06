package com.example.orderpay

import android.app.Application
import com.example.orderpay.di.DaggerAppComponent

class App: Application() {
    val appComponent = DaggerAppComponent.create()
}