package com.example.apptestes.architecture.repositorypattern

// Repository Pattern
/*
    Camada intermediária entre a lógica de negócios (UseCase ou ViewModel)
    e fonte de dados (banco de dados local ou API)
*/
class ProductRepository(private val dao: ProductDao) {
    suspend fun getAllProducts(): List<ProductModel> {
        return dao.getAll()
    }

    suspend fun addProduct(product: ProductModel) {
        dao.insert(product)
    }
}