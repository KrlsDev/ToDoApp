package com.example.todoapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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