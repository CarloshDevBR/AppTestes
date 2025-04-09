package com.example.apptestes.architecture.repositorypattern

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// DAO - Data Access Object
/*
    Abstrai a comunicação com o banco de dados
*/
@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    suspend fun getAll(): List<ProductModel>

    @Insert
    suspend fun insert(product: ProductModel)

    @Delete
    suspend fun delete(produto: ProductModel)
}