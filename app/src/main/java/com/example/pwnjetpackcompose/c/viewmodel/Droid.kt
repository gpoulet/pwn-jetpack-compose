package com.example.pwnjetpackcompose.c.viewmodel

import androidx.annotation.DrawableRes

data class Droid(
    val id: Int,
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String = "",
    val quantity: Int = 0,
)