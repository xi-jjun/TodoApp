package me.practices.todoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity("todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("subtitle")
    val subtitle: String,
    @ColumnInfo("done")
    val done: Boolean = false,
    @ColumnInfo("added")
    val createdAt: Long = System.currentTimeMillis(),
)

val TodoEntity.createdAtDate: String get() = SimpleDateFormat("yyyy/MM/dd hh:mm").format(Date(createdAt))
