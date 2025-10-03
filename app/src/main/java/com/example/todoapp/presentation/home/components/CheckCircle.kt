package com.example.todoapp.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Preview(showBackground = true)
@Composable
fun CheckCircle(checked: Boolean = false, onCheckedChange: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .size(25.dp)
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = CircleShape
            )
            .fillMaxSize()
            .clickable{
                onCheckedChange()
            }
    ) {
        if (checked) {
            Icon(
                painter = painterResource(R.drawable.check_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                contentDescription = "",
                tint = Color.Black
            )
        }
    }
}


