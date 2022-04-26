package com.example.todoapp_160919005_lukitaiswara.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
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
    val todoLD = MutableLiveData<Todo>()

    fun fetch(uuid:Int) {
        launch {
            val db = buildDB(getApplication())
            todoLD.value =  db.todoDao().selectTodo(uuid)
        }
    }

    fun update(title:String, notes:String, priority:Int, uuid:Int){
        launch {
            val db = buildDB(getApplication())
            db.todoDao().update(title, notes, priority, uuid)
        }
    }

    fun updateIsDone(uuid:Int){
        launch {
            val db = buildDB(getApplication())
            db.todoDao().updateIsDone(uuid)
        }
    }

    fun addTodo(list:List<Todo>) {
        launch {
            val db = buildDB(getApplication())
            db.todoDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}