package com.example.apptestes.android.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val date: String
)