package com.atm.codechallenge.ui.compose.atom

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.atm.codechallenge.ui.compose.theme.CodeChallengeTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeChallengeTheme {
        Greeting("Android")
    }
}