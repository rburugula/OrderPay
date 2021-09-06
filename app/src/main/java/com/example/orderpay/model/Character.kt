package com.example.orderpay.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val img: String,
    val status: String,
    val nickname: String,
) : Parcelable