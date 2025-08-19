package com.example.todoapp.domain.usecases

import com.example.todoapp.domain.repository.TaskRepository
import javax.inject.Inject

class DeleteTask @Inject constructor(
    private val taskRepository: TaskRepository
){

    suspend operator fun invoke(id: Int) {
        taskRepository.deleteTask(id)
    }

}