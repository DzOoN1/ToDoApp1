package com.example.todoapp1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp1.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo ORDER BY createdAt DESC")
    fun getAllToDos(): LiveData<List<ToDo>>
    @Insert
    fun addToDo(todo: ToDo)
    @Query("DELETE FROM ToDo where id = :id")
    fun deleteToDo(id: Int)
}