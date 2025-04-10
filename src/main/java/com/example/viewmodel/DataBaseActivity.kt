package com.example.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodel.databinding.ActivityMain2Binding

class DataBaseActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = MyDBHelper(this)

//        dbHelper.insert("Akshat Sir",22)
//        dbHelper.insert("Shivam Kapoor",26)
//        dbHelper.insert("Vanni",20)
//        dbHelper.insert("Gautam",23)
//        dbHelper.insert("Ajay",50)
//        dbHelper.insert("Imran",27)


//Updating the user
        val user = Users(
            id = 3,
            name ="Divay",
            age = 30
        )

//        dbHelper.updateUser(user)

//Deleting the User

//       dbHelper.deleteUser(18)

//Fetching the data
        val users = dbHelper.getUsers()
        users.forEach {
            Log.d("Users ","$users")
        }

        binding.userList.adapter = Adapter(users)
        binding.userList.layoutManager = LinearLayoutManager(this)
    }

}