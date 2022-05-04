package com.example.pwnjetpackcompose.a.modifiers

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.R
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme


@Composable
fun RoundImage(@DrawableRes id: Int, alt: String) {
    Image(
        painter = painterResource(id),
        contentDescription = alt,
        contentScale = ContentScale.Crop,            // crop the image
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)                       // clip to the circle shape
    )
}

@Preview
@Composable
fun PreviewR2() {
    PwnJetpackComposeTheme {
        RoundImage(id = R.drawable.r2d2, alt = "R2D2")
    }
}