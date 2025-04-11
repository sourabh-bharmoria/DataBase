package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/*
Extend AndroidViewModel when you want your ViewModel to receive the Application
instance safely from the system.ViewModel should not reference an Activity and fragments directly
as it can cause memory leaks.Application provides a safe and lifecycle independent way  to access context.
*/
class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val database = Room.databaseBuilder(application, ContactDatabase::class.java,"ContactDB").build()

    val contacts: LiveData<List<Contact>> = database.dao.getContacts()

//    fun insertContact(contact: Contact){
//        GlobalScope.launch{
//            database.dao.insertContact(contact)
//        }
//    }


}