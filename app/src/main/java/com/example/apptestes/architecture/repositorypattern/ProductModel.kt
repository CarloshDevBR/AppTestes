package com.example.apptestes.architecture.repositorypattern

import androidx.room.Entity
import androidx.room.PrimaryKey

// Model
/*
    Representa os dados e a lógica de negócios da aplicação.
*/
@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)