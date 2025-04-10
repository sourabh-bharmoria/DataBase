package com.example.viewmodel

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age INTEGER)"

        db?.execSQL(createTable)
        //execSQL is only used with create,insert,delete,update not with select

     //   val d  = this.writableDatabase
//writableDatabase ref is used for insert , delete and update
//readableDatabase ref is used for select

    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun insert(name: String,age: Int){
        var db = this.writableDatabase

        val value = ContentValues()
        value.put("name",name)
        value.put("age",age)
        db.insert("users",null,value)

//        db.close()
    }


    fun getUsers() : List<Users>{
        val db = this.readableDatabase
        val cursor = db.rawQuery("Select * from Users",null)
        val users = mutableListOf<Users>()

        while (cursor.moveToNext()){
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val age = cursor.getInt(2)
            users.add(Users(id,name,age))

        }

//        cursor.close()
        return users
    }

    fun updateUser(users: Users){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("name",users.name)
        values.put("age",users.age)

        db.update("users",values,"id = ?",arrayOf(users.id.toString()))
//Syntax for updating
//        update(
//            table: String,
//            values: ContentValues,
//            whereClause: String,
//            whereArgs: Array<String>?
//        )
    }

    fun deleteUser(id: Int){
        val db = this.writableDatabase
        val value = ContentValues()

        db.delete("users","id = ?",arrayOf(id.toString()))
    }

}