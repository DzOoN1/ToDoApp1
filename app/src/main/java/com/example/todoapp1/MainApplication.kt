package com.example.todoapp1

import android.app.Application
import androidx.room.Room
import com.example.todoapp1.db.ToDoDao
import com.example.todoapp1.db.ToDoDatabase

class MainApplication: Application() {

    companion object{
        lateinit var toDoDatabase: ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()
      toDoDatabase = Room.databaseBuilder(
            applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME
        ).build()
    }
}