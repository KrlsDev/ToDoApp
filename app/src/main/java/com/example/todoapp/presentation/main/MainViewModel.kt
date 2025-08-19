package com.example.todoapp.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.usecases.AddTask
import com.example.todoapp.domain.usecases.DeleteTask
import com.example.todoapp.domain.usecases.GetTasks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTasksUseCase: GetTasks,
    private val addTaskUseCase: AddTask,
    private val deleteTaskUseCase: DeleteTask
): ViewModel(){







    // Pruebas borrar
    fun borrar(): String {
        return "HOLA"
    }

    init {
        viewModelScope.launch {
            addTaskUseCase(Task(text = "Prueba", done = false))

            Log.d("MainViewModel", "Nueva tarea añadida")
            getTasksUseCase().collect { tasks ->
                // Aquí recibes cada emisión del Flow
                Log.d("MainViewModel", tasks.toString())
            }
        }
    }

}