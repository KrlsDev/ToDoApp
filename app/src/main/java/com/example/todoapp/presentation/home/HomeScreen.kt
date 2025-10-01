package com.example.todoapp.presentation.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.todoapp.R
import com.example.todoapp.presentation.home.components.NewTaskDialog
import com.example.todoapp.presentation.home.components.Card
import com.example.todoapp.presentation.home.components.Header
import com.example.todoapp.presentation.home.components.Sign
import com.example.todoapp.presentation.main.MainViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val mainViewModel: MainViewModel = hiltViewModel()
    val tasks by mainViewModel.tasks.collectAsState()
    val isAddTaskMenuVisbility by mainViewModel.isAddTaskMenuVisible.collectAsState()
    val newTaskInput by mainViewModel.newTaskInput.collectAsState()

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(visible = !isAddTaskMenuVisbility, enter = fadeIn(), exit = fadeOut()) {
                FloatingActionButton(
                    onClick = {
                        mainViewModel.showNewTaskDialog()
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .border(
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, color = Color.Black),
                        )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_add_2_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box() {

            LazyColumn {
                item {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                    ) {
                        Column(
                            modifier = Modifier
                                .width(IntrinsicSize.Min)
                        ) {
                            Header()
                            Sign()
                            Spacer(Modifier.padding(20.dp))
                        }
                    }


                }
                items(tasks) { task ->
                    Spacer(Modifier.height(6.dp))
                    Log.d(
                        "HomeScreen",
                        "text: " + task.text + " id: " + task.id + " done: " + task.done
                    )
                    Card(
                        text = task.text,
                        done = task.done,
                        id = task.id,
                        onToggleTask = { id ->
                            mainViewModel.deleteAndCompleteTask(id)
                            Log.d("HomeScreen", "id $id borrado")

                        }
                    )
                }
            }
            AnimatedVisibility(visible = isAddTaskMenuVisbility, enter = fadeIn(), exit = fadeOut()) {
                NewTaskDialog(
                    onSend = {
                        mainViewModel.hideNewTaskDialog()
                        mainViewModel.addNewTask()

                    },
                    value = newTaskInput,
                    onValueChange = { newValue ->
                        mainViewModel.updateNewTaskInput(newValue)
                    },
                )
            }
        }
    }


}