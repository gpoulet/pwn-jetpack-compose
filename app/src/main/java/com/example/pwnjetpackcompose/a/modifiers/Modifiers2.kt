package com.example.pwnjetpackcompose.a.modifiers

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.R
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun Item(title: String, subtitle: String = "", @DrawableRes image: Int) {
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable(onClick = {})
    ) {
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            RoundImage(image, title)
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = subtitle, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ItemPreview() {
    PwnJetpackComposeTheme {
        Item(title = "R2D2", "Astromecano", R.drawable.r2d2)
    }
}