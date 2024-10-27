package com.example.todoapp1

import java.time.Instant
import java.util.Date

object ToDoManager {

    private val todoList = mutableListOf<ToDo>()

    fun getAllToDos(): List<ToDo>{
        return todoList
    }
    fun addToDo(title: String){
        todoList.add(ToDo(System.currentTimeMillis().toInt(),
            title, Date.from(Instant.now())))
    }
    fun deleteToDo(id:Int){
        todoList.removeIf {
            it.id == id
        }

    }
}
