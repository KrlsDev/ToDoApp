package com.example.todoapp.presentation.home.components

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun Header(modifier: Modifier = Modifier) {
    Box() {
        Text(
            text = "TodoApp",
            color = Color(0xffa3ff8b),
            fontSize = 80.sp,

        )
        Text(
            text = "TodoApp",
            color = Color(0xFF000000),
            fontSize = 80.sp,
            style = TextStyle(
                drawStyle = Stroke(
                    width = 5f
                ),
            ),
        )
    }
}

