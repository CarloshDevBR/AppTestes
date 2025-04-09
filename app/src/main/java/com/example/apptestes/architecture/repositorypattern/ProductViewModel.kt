package com.example.apptestes.architecture.repositorypattern

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// ViewModel
/*
    Faz o porte entre View e Model.
    Contém lógica de apresentação e manipula os dados do Model de
    forma que a View possa apresentar.
*/
class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val _product = MutableLiveData<List<ProductModel>>()
    val product: LiveData<List<ProductModel>> = _product

    fun getAllProducts() {
        viewModelScope.launch {
            _product.value = repository.getAllProducts()
        }
    }

    fun addProduct(product: ProductModel) {
        viewModelScope.launch {
            repository.addProduct(product)
            getAllProducts()
        }
    }
}