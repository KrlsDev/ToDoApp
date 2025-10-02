package com.example.todoapp.domain.di

import android.app.Application
import com.example.todoapp.data.local.TasksDao
import com.example.todoapp.data.local.TasksDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTasksDataBase(application: Application): TasksDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = TasksDataBase::class.java,
            name = "tasks_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTasksDao(
        tasksDataBase: TasksDataBase
    ): TasksDao = tasksDataBase.tasksDao


}