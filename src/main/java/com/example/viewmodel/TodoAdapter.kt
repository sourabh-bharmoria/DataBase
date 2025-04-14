package com.example.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.databinding.TodoItemLayoutBinding

class TodoAdapter(val todos: List<Todo>,val viewModel: TodoViewModel): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

//    private lateinit var binding: TodoItemLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): TodoViewHolder {
        val binding = TodoItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder,position: Int) {
        holder.title.text = todos[position].title
        holder.description.text = todos[position].description
  //Deleting the Todo when clicked on the trash icon image
        holder.deleteIcon.setOnClickListener {
            viewModel.deleteTodo(todos[position])
        }

    }

    override fun getItemCount(): Int {
        return todos.size
    }


   class TodoViewHolder(val binding: TodoItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val title = binding.title
        val description = binding.description
        val deleteIcon = binding.deleteimg
    }
}
