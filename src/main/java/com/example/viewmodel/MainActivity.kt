package com.example.viewmodel

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val viewModel: MyViewModel by viewModels()
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        val textView = binding.textView
        val button1 = binding.button1
        val button2 = binding.button2
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)


        viewModel.counterValue.observe(this){counter ->
            textView.text = counter.toString() //UI update automatically when the LiveData changes
        }

        button1.setOnClickListener{
           // viewModel.updateText("Hello , Divay")
            viewModel.updateCounter()
        }

        button2.setOnClickListener {
            viewModel.resetCounter()
        }

        setContentView(view)
    }
}

