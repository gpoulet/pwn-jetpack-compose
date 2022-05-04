package com.example.pwnjetpackcompose.b.state

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.R
import com.example.pwnjetpackcompose.a.modifiers.RoundImage
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun ItemWithState(
    title: String,
    subtitle: String = "",
    @DrawableRes image: Int
) {
    var quantity by remember { mutableStateOf(0) }
//    var expanded by rememberSaveable { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable(onClick = {})
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(image, title)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = subtitle, style = MaterialTheme.typography.body2)
            }
            Quantity(quantity = quantity, increase = { quantity++ }, decrease = { quantity-- })
        }
    }
}

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

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ItemPreview() {
    PwnJetpackComposeTheme {
        ItemWithState(
            title = "R2D2",
            "Astromecano",
            R.drawable.r2d2
        )
    }
}