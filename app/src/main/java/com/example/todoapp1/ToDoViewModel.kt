package com.example.todoapp1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel : ViewModel() {

    val toDoDao = MainApplication.toDoDatabase.getToDoDao()

    val todoList: LiveData<List<ToDo>> = toDoDao.getAllToDos()


    fun addToDo(item: String) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.addToDo(ToDo(toDoString = item, createdAt = Date.from(Instant.now())))
            }


    }

    fun deleteToDo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.deleteToDo(id)


        }
    }
}