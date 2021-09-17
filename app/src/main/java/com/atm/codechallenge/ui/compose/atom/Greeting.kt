package com.atm.codechallenge.ui.compose.atom

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.atm.codechallenge.ui.compose.theme.CodeChallengeTheme

@Composable
fun Greeting(name: MutableState<String>) {
    Text(text = "Hello ${name.value}!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeChallengeTheme {
        val state = remember { mutableStateOf("Greeting!") }
        Greeting(state)
    }
}