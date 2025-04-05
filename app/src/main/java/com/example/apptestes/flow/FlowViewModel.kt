package com.example.apptestes.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {
    // StateFlow é uma ótima opção para classes que precisam manter um estado mutável observável.
    // Não trabalha bem com o ciclo de vida
    private val _stateFlow = MutableStateFlow("Hello")

    // asStateFlow: apenas leitura
    val stateFlow: StateFlow<String> = _stateFlow.asStateFlow()

    fun getFlow() = flow {
        // emit vai emitir valores no flow
        emit("Flow emitido")
    }

    fun getFlow2() = flow {
        emit(2000)
    }

    fun collectFlow() {
        // Flow é trabalha com corrotinas
        viewModelScope.launch {
            getFlow()
                // adiciona um delay
                .debounce(2000)
                // Junta dois fluxos, emitindo em pares
                .zip(getFlow2()) { a, b ->
                    "$a - $b"
                }
                //Combina dois fluxos reagindo a qualquer emissão de qualquer um
                .combine(getFlow2()) { a, b ->
                    "$a - $b"
                }
                // Emite apenas valores filtrados
                .filter {
                    it.isNotEmpty()
                }
                // Pega os n primeiros valores
                .take(2)
                // Evita emitir valores repetidos consecutivos
                .distinctUntilChanged()
                .onStart {
                    // É chamado quando o flow inicia
                }
                .catch {
                    // Tratamento de erro dentro de um flow
                }
                .map {
                    // Transforma um valor emitido
                }
                .onCompletion {
                    // Executa quando o flow termina, seja com sucesso ou com erro
                    // Útil para liberar recursos, esconder loadings e etc..
                }
                .collectLatest {
                    // Cancela a coleta anterior se um novo valor for emitido antes da conclusão
                }
            //.collect {
            // Coleta os valores emitidos pelo flow
            //}

            // Também temos:
            //  flatMapConcat / flatMapMerge / flatMapLatest
            //  Usa um valor emitido para iniciar outro fluxo
            //  flow.flatMapLatest { valor -> outroFlow(valor) }

            // Emite varios valores
            //.transform {
            //   emit(0)
            //   emit(1)
            //   emit(2)
            // }
            // coleta tudo em uma lista
            // .toList()
        }
    }

    fun setFlow() {
        // É possível utilizar o valor atual
        _stateFlow.update { "$it Flow" }

        // Altera o valor diretamente
        // _flow.value = "Hello world"
    }
}