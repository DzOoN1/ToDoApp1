package com.example.todoapp1

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var toDoString: String,
    val createdAt: Date
)


