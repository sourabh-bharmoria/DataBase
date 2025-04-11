package com.example.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodel.databinding.RoomActivityBinding


class RoomActivity: AppCompatActivity() {
    private lateinit var binding: RoomActivityBinding
//    lateinit var database: ContactDatabase
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RoomActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

//Shifted the database build/creation and other insert,getContacts methods into ContactViewModel class

//        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java,"ContactDB").build()

//        GlobalScope.launch {
//            database.dao.insertContact(Contact(9,"Divay","Sharma","290338"))
//            database.dao.insertContact(Contact(2,"Gajinder","Singh","294338"))
//            database.dao.insertContact(Contact(3,"Ajay","Godara","290389"))
//            database.dao.insertContact(Contact(4,"Vanni","Sharma","099876"))
//            database.dao.insertContact(Contact(5,"Gautam","Gupta","473593"))
//
//
//        }
//        database.dao.getContacts().observe(this){contacts ->
          viewModel.contacts.observe(this){contacts ->
            binding.contactList.adapter = RoomAdapter(contacts)
            binding.contactList.layoutManager = LinearLayoutManager(this)
        }

    }
}