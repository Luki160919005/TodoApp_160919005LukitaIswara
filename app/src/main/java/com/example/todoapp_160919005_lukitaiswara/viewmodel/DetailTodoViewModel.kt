package com.example.todoapp_160919005_lukitaiswara.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.todoapp_160919005_lukitaiswara.model.Todo
import com.example.todoapp_160919005_lukitaiswara.model.TodoDatabase
import com.example.todoapp_160919005_lukitaiswara.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addTodo(list: List<Todo>) {
        launch {
            val db = buildDB(getApplication())
            db.todoDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}