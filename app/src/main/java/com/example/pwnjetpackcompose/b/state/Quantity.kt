package com.example.pwnjetpackcompose.b.state

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun Quantity(quantity: Int = 0, increase: () -> Unit, decrease: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (quantity > 0) {
            CircleButton("-", decrease)
        }
        Text(text = quantity.toString(), modifier = Modifier.padding(8.dp))
        CircleButton("+", increase)
    }
}

@Composable
fun CircleButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = Modifier.size(30.dp)
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun QuantityPreview() {
    PwnJetpackComposeTheme {
        Quantity(quantity = 1, increase = { }, decrease = {})
    }
}