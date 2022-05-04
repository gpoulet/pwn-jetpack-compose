package com.example.pwnjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.pwnjetpackcompose.c.viewmodel.DroidViewModel
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun AppViewModel(droidViewModel: DroidViewModel = DroidViewModel()) {
    val droids by droidViewModel.droids.observeAsState(listOf())
    LazyColumn {
        items(droids) { droid ->
            DroidCard(
                title = droid.title,
                subtitle = droid.subtitle,
                image = droid.image,
                quantity = droid.quantity,
                increase = {
                    droidViewModel.increase(droid.id)
                },
                decrease = {
                    droidViewModel.decrease(droid.id)
                })
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppViewModelPreview() {
    PwnJetpackComposeTheme {
        AppViewModel()
    }
}