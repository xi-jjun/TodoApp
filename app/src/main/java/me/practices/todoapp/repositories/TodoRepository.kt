package me.practices.todoapp.repositories

import kotlinx.coroutines.flow.Flow
import me.practices.todoapp.database.TodoEntity

interface TodoRepository {
    suspend fun addTodo(todo: TodoEntity)
    suspend fun getTodos(): Flow<List<TodoEntity>>
    suspend fun updateTodo(todo: TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
}
