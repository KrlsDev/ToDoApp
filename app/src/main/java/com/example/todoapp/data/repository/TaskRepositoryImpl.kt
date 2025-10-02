package com.example.todoapp.data.repository

import com.example.todoapp.data.local.TasksDao
import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val tasksDao: TasksDao
): TaskRepository {


    override suspend fun addTask(task: Task) {
        tasksDao.insert(task)
    }

    override suspend fun deleteTask(id: Int) {
        tasksDao.delete(id)
    }

    override suspend fun getTasks(): Flow<List<Task>> {
        return tasksDao.getTasks()
    }


}