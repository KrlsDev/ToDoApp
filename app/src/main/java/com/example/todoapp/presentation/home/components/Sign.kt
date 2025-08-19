package com.example.todoapp.presentation.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Sign(modifier: Modifier = Modifier) {
    Text(
        text = "By KrlsDev",
        color = Color(0xffa3ff8b),
        fontSize = 27.sp,
        style = TextStyle(Color.Black, drawStyle = Stroke(1f))
    )
}