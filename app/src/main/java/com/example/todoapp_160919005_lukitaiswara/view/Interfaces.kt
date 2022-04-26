package com.example.todoapp_160919005_lukitaiswara.view

import android.view.View
import android.widget.CompoundButton
import com.example.todoapp_160919005_lukitaiswara.model.Todo

interface TodoCheckedChangeListerner{
    fun onTodoCheckedChange(cb:CompoundButton, isChecked:Boolean, obj: Todo)

}
interface TodoEditClickListener {
    fun onTodoEditClick(v: View)
}