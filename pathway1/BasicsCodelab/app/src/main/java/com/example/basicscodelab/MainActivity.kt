package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(names: List<String> = listOf("default", "compose")) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(vertical = 30.dp)) {
            for (name in names) Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = (if (expanded.value) 48 else 0).dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text("$name!!!")
            }
            OutlinedButton(onClick = { expanded.value = expanded.value.not() }) {
                Text("Show " + ("less".takeIf { expanded.value } ?: "more"))
            }
        }
    }
}

@Preview(showBackground = true, name = "Preview Name", widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp(listOf("input", "value", "??"))
    }
}

@Preview(showBackground = true, name = "Preview Name2")
@Composable
fun Preview2() {
    BasicsCodelabTheme {
        Greeting("World!")
    }
}