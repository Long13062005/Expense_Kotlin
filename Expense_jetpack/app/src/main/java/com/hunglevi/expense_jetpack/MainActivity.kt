package com.hunglevi.expense_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hunglevi.expense_jetpack.ui.theme.Expense_JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Expense_JetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GetLayout(
                        "Hello, Jetpack Compose!",
                        innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun GetLayout(title: String = "", innerPadding: PaddingValues? = PaddingValues(0.dp)) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        GetTextTitle(title, innerPadding)
        Button (
            onClick = { /* Do something! */ },
            modifier = Modifier.padding(innerPadding!!),
        ) {
            Text("Click me!")
        }
    }
}

@Composable
fun GetTextTitle(title: String = "", innerPadding: PaddingValues? = PaddingValues(0.dp)) {
    Text(
        text = title,
        modifier = Modifier.padding(innerPadding!!),
        fontSize = 24.sp,
        color = Color.Red,
        textAlign = TextAlign.Center
    )
}
