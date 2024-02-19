package me.practices.todoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity("todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo("title")
    var title: String,
    @ColumnInfo("subtitle")
    var subtitle: String,
    @ColumnInfo("done")
    var done: Boolean = false,
    @ColumnInfo("added")
    var added: Long = System.currentTimeMillis(),
)

val TodoEntity.addDate: String get() = SimpleDateFormat("yyyy/MM/dd hh:mm").format(Date(added))
