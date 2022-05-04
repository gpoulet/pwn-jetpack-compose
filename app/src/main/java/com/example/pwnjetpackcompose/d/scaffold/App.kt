package com.example.pwnjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.c.viewmodel.DroidViewModel
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun App(droidViewModel: DroidViewModel = DroidViewModel()) {
    val droids by droidViewModel.droids.observeAsState(listOf())
    Scaffold(
        topBar = {
            AppBar(cartCount = droids.filter { it.quantity > 0 }.map { it.quantity }.sum() ?: 0)
        })
    {
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

}

@Composable
fun AppBar(cartCount: Int = 0) {
    TopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "DroidShop", Modifier.weight(1f))
            ShoppingCart(cartCount)
        }
    },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Menu, "menu")
            }
        })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShoppingCart(count: Int) {
    if (count > 0) {
        BadgeBox(
            modifier = Modifier.padding(end = 12.dp),
            badgeContent = { Text(count.toString()) },
            backgroundColor = MaterialTheme.colors.error
        ) {
            Icon(
                Icons.Filled.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    } else {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.ShoppingCart, "Cart")
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AppViewModelPreview2() {
    PwnJetpackComposeTheme {
        App()
    }
}