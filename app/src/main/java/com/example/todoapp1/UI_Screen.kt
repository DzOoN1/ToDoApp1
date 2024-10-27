package com.example.todoapp1

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale
import kotlin.concurrent.timerTask

@Composable
fun ToDoFirstPage(viewModel: ToDoViewModel) {
    val lista by viewModel.todoList.observeAsState()
    var item by rememberSaveable() { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            OutlinedTextField(value = item, onValueChange = {
                item = it
            },
                label = {"Enter new TODO"},
                modifier = Modifier.weight(0.7f))
            Button(onClick = {
                viewModel.addToDo(item)
                item = ""
            }) {
                Text(text = "ADD", fontSize = 16.sp)

            }

        }
        lista?.let {
            LazyColumn(content = {
                itemsIndexed(it){index: Int, item: ToDo ->
                    ToDoItem(item, onDelete = {
                        viewModel.deleteToDo(item.id)
                    })

                }
            },
                modifier = Modifier.fillMaxSize()
            )
        } ?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No Items yet",
            fontSize = 20.sp)





    }

}

@Composable
fun ToDoItem(item: ToDo, onDelete: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = SimpleDateFormat(("HH:mm:aa, dd/mm/yyyy"),Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray)
            Text(text = item.toDoString,
                fontSize = 26.sp,
                color = Color.White)
        }
        IconButton(onClick = {
            onDelete()
        }) {
            Icon(painter = painterResource(R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White)
        }

    }
}