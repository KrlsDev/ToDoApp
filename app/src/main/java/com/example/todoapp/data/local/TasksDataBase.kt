package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.domain.model.Task

@Database(entities = [Task::class],version = 1,)
abstract class TasksDataBase: RoomDatabase() {

    abstract val tasksDao: TasksDao

}