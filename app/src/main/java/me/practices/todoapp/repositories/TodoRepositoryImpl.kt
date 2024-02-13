package me.practices.todoapp.repositories

import kotlinx.coroutines.flow.Flow
import me.practices.todoapp.database.TodoDatabase
import me.practices.todoapp.database.TodoEntity

class TodoRepositoryImpl(
    private val database: TodoDatabase
) : TodoRepository {
    private val dao = database.todoDao()

    override suspend fun addTodo(todo: TodoEntity) = dao.addTodo(todo)

    override suspend fun getTodos(): Flow<List<TodoEntity>> = dao.getTodos()

    override suspend fun updateTodo(todo: TodoEntity) = dao.updateTodo(todo)

    override suspend fun deleteTodo(todo: TodoEntity) = dao.deleteTodo(todo)
}
