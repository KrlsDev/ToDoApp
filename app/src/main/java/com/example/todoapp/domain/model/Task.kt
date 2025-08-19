package com.example.todoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val done: Boolean = false
)
