package com.example.pwnjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.pwnjetpackcompose.R
import com.example.pwnjetpackcompose.a.modifiers.Item
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun DroidCardWithState(
    title: String,
    subtitle: String = "",
    @DrawableRes image: Int
) {
    var quantity by rememberSaveable { mutableStateOf(0) }
//    var expanded by remember { mutableStateOf(false) }

    DroidCard(
        title,
        subtitle,
        image,
        quantity,
        increase = { quantity++ },
        decrease = { quantity-- })
}

@Composable
fun DroidCard(
    title: String,
    subtitle: String = "",
    @DrawableRes image: Int,
    quantity: Int = 0,
    increase: () -> Unit,
    decrease: () -> Unit
) {
    Item(
        title = title,
        subtitle = subtitle,
        image = image
    ) {
        Quantity(quantity = quantity, increase = increase, decrease = decrease)
    }

}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DroidCardWithStatePreview() {
    PwnJetpackComposeTheme {
        DroidCardWithState(
            title = "R2D2",
            "Astromecano",
            R.drawable.r2d2
        )
    }
}