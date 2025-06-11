package com.example.apptestes.architecture.dto

// DTO - Data Transfer Object
/*
    Objeto usado para transportar dados entre processos, camadas ou serviços
*/

// Resposta externa
data class Product(
    val id: Long,
    val nome: String,
    val price: Double,
    val description: String
)

// DTO da resposta
data class ProductDTO(
    val id: Long,
    val nome: String
)