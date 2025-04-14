package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val database =
        Room.databaseBuilder(application, TodoDatabase::class.java, "Todos").build()

    val todos: LiveData<List<Todo>> = database.dao.getAllTodo()

    fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            database.dao.insertTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            database.dao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            database.dao.deleteTodo(todo)
        }
    }

}