package com.example.viewmodel

import androidx.room.Entity
import androidx.room.PrimaryKey

//creating the database table whose name will be Contact
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)//id is the primary key with auto increment
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)
