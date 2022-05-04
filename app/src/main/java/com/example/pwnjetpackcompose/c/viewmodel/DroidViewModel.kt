package com.example.pwnjetpackcompose.c.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pwnjetpackcompose.R

class DroidViewModel : ViewModel() {
    var droids = MutableLiveData(
        listOf(
            Droid(id = 0, image = R.drawable.r2d2, title = "R2D2", subtitle = "Astromécano"),
            Droid(id = 1, image = R.drawable.c3po, title = "C3P0", subtitle = "Droid de protocole"),
            Droid(id = 2, image = R.drawable.bb8, title = "BB-8", subtitle = "Astromecano"),
            Droid(
                id = 3,
                image = R.drawable.sonde,
                title = "Sonde impériale",
                subtitle = "Explorateur"
            ),
            Droid(id = 4, image = R.drawable.bb9e, title = "BB-9E", subtitle = "Astromecano")
        )
    )

    fun increase(id: Int) {
        droids.value =
            droids.value?.map { if (it.id == id) it.copy(quantity = it.quantity + 1) else it }
    }

    fun decrease(id: Int) {
        droids.value =
            droids.value?.map { if (it.id == id) it.copy(quantity = it.quantity - 1) else it }
    }
}