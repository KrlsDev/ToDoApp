package com.example.todoapp.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.todoapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {

    @Insert
    suspend fun insert(task: Task)

    @Query("DELETE FROM task WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<Task>>

}

