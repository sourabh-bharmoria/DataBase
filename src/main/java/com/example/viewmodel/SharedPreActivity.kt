package com.example.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodel.databinding.SharedactivityMainBinding

class SharedPreActivity: AppCompatActivity() {

    private lateinit var binding: SharedactivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SharedactivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference= getSharedPreferences("pref1",MODE_PRIVATE)
// Shared preference is used to store small amount of data
        val editor = sharedPreference.edit()

        binding.savebtn.setOnClickListener {
            val name = binding.EditText1.text.toString()
            val age = binding.EditText2.text.toString().toInt()
            val isAdult = binding.checkbox.isChecked

            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
                //can use commit and it will also return a bool value but commit will put data synchronously which can block the main thread or UI
            }

        }

        binding.retrievebtn.setOnClickListener {
            val name = sharedPreference.getString("name",null)
            val age  = sharedPreference.getInt("age",0)
            val isAdult = sharedPreference.getBoolean("isAdult",false)

            //There are also remove and clear method

            binding.EditText1.setText(name)
            binding.EditText2.setText(age.toString())//because age is an integer
            binding.checkbox.isChecked = isAdult

        }



    }

}