package me.practices.todoapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.practices.todoapp.database.TodoEntity
import me.practices.todoapp.repositories.TodoRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val repository: TodoRepository by inject()

    private val _todos: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val todos = _todos.asStateFlow()

    init {
        getTodos()
    }

    fun getTodos() {
        Log.d("HomeViewModel", "start getTodos")
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTodos().collect {
                Log.d("HomeViewModel", "item -> ${it}")
                _todos.update { it }
            }
        }
        Log.d("HomeViewModel", "end getTodos => result : ${todos}")
    }

    fun addTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todo)
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(todo)
        }
    }
}
