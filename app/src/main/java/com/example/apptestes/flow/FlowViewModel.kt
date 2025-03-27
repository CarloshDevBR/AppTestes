package com.example.apptestes.flow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlowViewModel : ViewModel() {
    // StateFlow é uma ótima opção para classes que precisam manter um estado mutável observável.
    // Não trabalha bem com o ciclo de vida
    private val _flow = MutableStateFlow("Hello")

    // asStateFlow: apenas leitura
    val flow: StateFlow<String> = _flow.asStateFlow()


    fun setFlow() {
        // É possível utilizar o valor atual
        _flow.update { "$it Flow" }

        // Altera o valor diretamente
        // _flow.value = "Hello world"
    }
}