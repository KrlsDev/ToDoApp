package com.example.todoapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.usecases.AddTask
import com.example.todoapp.domain.usecases.DeleteTask
import com.example.todoapp.domain.usecases.GetTasks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTasksUseCase: GetTasks,
    private val addTaskUseCase: AddTask,
    private val deleteTaskUseCase: DeleteTask
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _isAddTaskMenuVisible = MutableStateFlow(false)
    val isAddTaskMenuVisible = _isAddTaskMenuVisible.asStateFlow()

    private val _newTaskInput = MutableStateFlow("")
    val newTaskInput = _newTaskInput.asStateFlow()

    init {

        viewModelScope.launch {
            getTasksUseCase().collect { lista ->
                _tasks.value = lista
            }
        }
    }

    fun deleteAndCompleteTask(id: Int) {
        val newTasks = _tasks.value.map { task ->
            if (task.id == id) {
                task.copy(done = true)
            } else {
                task
            }
        }

        _tasks.value = newTasks
        viewModelScope.launch {
            delay(150)
            deleteTaskUseCase(id)
        }
    }

    fun updateNewTaskInput(newText: String) {
        _newTaskInput.value = newText
    }

    fun showNewTaskDialog() {
        _isAddTaskMenuVisible.value = true
    }

    fun hideNewTaskDialog() {
        _isAddTaskMenuVisible.value = false
        _newTaskInput.value = ""
    }

    fun addNewTask() {
        if (_newTaskInput.value.isNotBlank()) {
            viewModelScope.launch {
                addTaskUseCase(Task(id = 0, text = _newTaskInput.value.trim(), done = false))
                _newTaskInput.value = ""
            }
        }
    }

}