package com.example.orderpay.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val img: String,
    val occupation: ArrayList<String>,
    val status: String,
    val nickName: String,
    val appearance: ArrayList<Int>
) : Parcelable