package com.example.apptestes.architecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel
/*
    Faz o porte entre View e Model.
    Contém lógica de apresentação e manipula os dados do Model de
    forma que a View possa apresentar.
*/
class CountViewModel : ViewModel() {
    private val count = CountModel()

    private val _countView = MutableLiveData<Int>()
    val countView: LiveData<Int> = _countView

    init {
        _countView.value = count.value
    }

    fun increment() {
        count.value++
        _countView.value = count.value
    }
}