package com.example.todoapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.poppins

@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        text = "TodoApp",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 65.sp,
        fontFamily = poppins,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}


