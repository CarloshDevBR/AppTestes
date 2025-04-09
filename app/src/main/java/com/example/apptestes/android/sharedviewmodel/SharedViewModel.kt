package com.example.apptestes.android.sharedviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel : ViewModel() {
    // Estado compartilhado entre telas
    private val _sharedText = MutableStateFlow("Texto inicial")
    val sharedText: StateFlow<String> = _sharedText.asStateFlow()

    // Função para atualizar o estado
    fun updateText(newText: String) {
        _sharedText.value = newText
    }
}