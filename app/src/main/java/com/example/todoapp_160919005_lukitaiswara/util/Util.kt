package com.example.todoapp_160919005_lukitaiswara.util

import android.content.Context
import androidx.room.Room
import com.example.todoapp_160919005_lukitaiswara.model.TodoDatabase

val DB_NAME = "tododb"

fun buildDB(context:Context):TodoDatabase{
    val db = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME).build()
    return db
}