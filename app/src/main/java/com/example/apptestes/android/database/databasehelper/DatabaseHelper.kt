package com.example.apptestes.android.database.databasehelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,
    com.example.apptestes.android.database.databasehelper.DatabaseHelper.Companion.DB_NAME, null,
    com.example.apptestes.android.database.databasehelper.DatabaseHelper.Companion.DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        try {
            val sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                name varchar(100),
                date DATE 
            )
        """

            db?.execSQL(sql)
        } catch (error: Exception) {
            error.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        const val DB_NAME = "teste"
        const val DB_VERSION = 1
    }
}