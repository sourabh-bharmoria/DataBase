package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//This is the data access object interface which is used to interact with the database it contain all db
//related methods. IT is SQL interface.
@Dao
interface ContactDao {

//Convenince Methods
//suspend fun is used to avoid blocking the Main UI Thread which can cause issue and errors.
    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

//Query methods
    @Query("Select * from contact")
    fun getContacts(): LiveData<List<Contact>>

}