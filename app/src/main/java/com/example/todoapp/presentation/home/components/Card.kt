package com.example.todoapp.presentation.home.components

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.theme.poppins


@Composable
fun Card(
    modifier: Modifier = Modifier,
    text: String = "",
    done: Boolean = false,
    id: Int = 0,
    onToggleTask: (Int) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, color = Color.Black),
            )
            .background(color = MaterialTheme.colorScheme.secondary)


    ) {
        Checkbox(
            checked = done,
            onCheckedChange = {
                onToggleTask(id)
            },
            colors = CheckboxColors(
                uncheckedBoxColor = Color.White,
                checkedCheckmarkColor = Color.Black,
                uncheckedCheckmarkColor = Color.Black,
                checkedBoxColor = Color.White,
                disabledCheckedBoxColor = Color.Red,
                disabledUncheckedBoxColor = Color.Red,
                disabledIndeterminateBoxColor = Color.Red,
                checkedBorderColor = Color.Black,
                uncheckedBorderColor = Color.Black,
                disabledBorderColor = Color.Red,
                disabledUncheckedBorderColor = Color.Black,
                disabledIndeterminateBorderColor = Color.Red
            )
        )
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.Black,
            fontFamily = poppins,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )

    }
}