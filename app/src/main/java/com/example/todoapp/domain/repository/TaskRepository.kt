package com.example.todoapp.domain.repository

import com.example.todoapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun addTask(task: Task)

    suspend fun deleteTask(id: Int)

    suspend fun getTasks(): Flow<List<Task>>

}