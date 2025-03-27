package com.example.apptestes.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    // Trabalha bem com o ciclo de vida
    // Não é Reativo
    private val _livedata = MutableLiveData<String?>()
    // get(): apenas leitura
    val livedata: LiveData<String?> get() = _livedata

    fun setLiveData() {
        // altera diretamente pelo value
        _livedata.value = "Hello LiveData"
    }
}