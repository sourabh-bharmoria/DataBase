package com.example.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodel.databinding.TodoActivityBinding
import com.example.viewmodel.databinding.TodoItemLayoutBinding

class TodoActivity: AppCompatActivity() {

    private lateinit var binding: TodoActivityBinding
    private lateinit var viewModel: TodoViewModel
//    private lateinit var itemView: TodoItemLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TodoActivityBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        setContentView(binding.root)


//        viewModel.insertTodo(Todo(1, "Buy groceries", "Milk, Eggs, Bread"))
//        viewModel.insertTodo(Todo(2, "Watch YouTube", "Watch documentary"))
//        viewModel.insertTodo(Todo(3, "Workout", "30-minute cardio session"))
//        viewModel.insertTodo(Todo(4, "Read book", "Read 'Atomic Habits' for 1 hour"))
//        viewModel.insertTodo(Todo(5, "Call Mom", "Catch up and check in"))
//        viewModel.insertTodo(Todo(6, "Clean room", "Organize desk and wardrobe"))
//        viewModel.insertTodo(Todo(7, "Learn Kotlin", "Work on Kotlin tutorials"))
//        viewModel.insertTodo(Todo(8, "Meditate", "10 minutes mindfulness session"))
//        viewModel.insertTodo(Todo(9, "Update resume", "Add latest project"))
//        viewModel.insertTodo(Todo(10, "Plan weekend", "Decide on movie or hiking trip"))

        binding.addbtn.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_todo,null)
            val title = dialogView.findViewById<EditText>(R.id.editTextTitle)
            val description = dialogView.findViewById<EditText>(R.id.editTextDescription)

            val dialog = AlertDialog.Builder(this)
                .setTitle("Add Todo")
                .setView(dialogView)
                .setPositiveButton("Add"){_,_ ->
                    val title = title.text.toString()
                    val description = description.text.toString()

                    viewModel.insertTodo(Todo(title = title, description = description))
                }
                .setNegativeButton("Cancel",null)
                .create()

            dialog.show()
        }

//        itemView.deleteimg.setOnClickListener {
//            viewModel.deleteTodo(Todo())
//        }


        viewModel.todos.observe(this){todos->
            binding.todoList.adapter = TodoAdapter(todos,viewModel)
            binding.todoList.layoutManager = LinearLayoutManager(this)
        }


    }

}