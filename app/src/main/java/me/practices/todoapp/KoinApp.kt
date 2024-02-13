package me.practices.todoapp

import android.app.Application
import androidx.room.Room
import me.practices.todoapp.database.TodoDatabase
import me.practices.todoapp.repositories.TodoRepository
import me.practices.todoapp.repositories.TodoRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

// Koin 이라는 의존성이 존재. 따라서 이름이 Koin
class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    Room.databaseBuilder(this@KoinApp, TodoDatabase::class.java, "db")
                        .build()
                }
                single {
                    TodoRepositoryImpl(database = get())
                } bind TodoRepository::class
            })
        }
    }
}
