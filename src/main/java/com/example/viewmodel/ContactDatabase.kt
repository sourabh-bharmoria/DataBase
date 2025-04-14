package com.example.viewmodel

import androidx.room.Database
import androidx.room.RoomDatabase

//This is where database is set it  takes the entity class and version(which is updated when some change happen
//in database.
@Database(
    entities = [Contact::class],
    version = 1
)
//THis is an abstract class used provide the dao properties
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: ContactDao

}