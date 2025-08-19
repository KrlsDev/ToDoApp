package com.example.todoapp.domain.usecases

import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasks @Inject constructor(
    private val taskRepository: TaskRepository
){

    suspend operator fun invoke(): Flow<List<Task>> {
        return taskRepository.getTasks()
    }

}