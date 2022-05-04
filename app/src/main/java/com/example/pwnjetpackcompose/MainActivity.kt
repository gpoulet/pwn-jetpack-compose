package com.example.pwnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pwnjetpackcompose.ui.theme.PwnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PwnJetpackComposeTheme {
                    Greeting("Android")
                }
            }
    }
}

@Composable
fun Greeting(name: String) {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(4.dp),
                    color = MaterialTheme.colors.background
                ) {
    Text(text = "Hello $name!")
        }
}

@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
//@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun DefaultPreview() {
    PwnJetpackComposeTheme {
        Greeting("Android")
    }
}