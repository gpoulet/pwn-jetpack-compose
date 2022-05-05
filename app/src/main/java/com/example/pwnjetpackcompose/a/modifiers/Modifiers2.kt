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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.R
import com.example.pwnjetpackcompose.b.state.Quantity
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

@Composable
fun Item(
    modifier: Modifier = Modifier,
    title: String = "",
    subtitle: String = "",
    @DrawableRes image: Int = 0,
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = modifier
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
            RoundImage(id = image, alt = title)
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = subtitle, style = MaterialTheme.typography.body2)
            }
            content()
        }
    }
}


@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ItemPreview() {
    PwnJetpackComposeTheme {
        Item(title = "R2D2", subtitle = "Astromecano", image = R.drawable.r2d2)
    }
}