package com.example.todoapp1.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp1.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class ToDoDatabase: RoomDatabase(){

    companion object{
        const val NAME = "ToDo_DB"
    }
    abstract fun getToDoDao(): ToDoDao
}