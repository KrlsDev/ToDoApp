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
fun Sign(modifier: Modifier = Modifier) {
    Text(
        text = "By KrlsDev",
        color = MaterialTheme.colorScheme.inverseSurface,
        fontSize = 27.sp,
        fontFamily = poppins,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth()
    )
}