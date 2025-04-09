package com.example.apptestes.android.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<UsersEntity>

    @Insert
    suspend fun add(user: UsersEntity): Long

    @Update
    suspend fun update(user: UsersEntity): Int

    @Delete
    suspend fun delete(user: UsersEntity): Int
}