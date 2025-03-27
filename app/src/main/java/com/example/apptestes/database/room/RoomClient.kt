package com.example.apptestes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UsersEntity::class], version = 1)
abstract class RoomClient : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: RoomClient? = null

        fun getDataBase(context: Context): RoomClient {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    RoomClient::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance

                return instance
            }
        }

        const val DB_NAME = "teste"
    }
}