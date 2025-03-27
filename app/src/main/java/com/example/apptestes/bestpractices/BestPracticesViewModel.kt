package com.example.apptestes.bestpractices

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FakeDao(
    private val context: Context,
) {
    // Retorna um fluxo de dados
    fun getAll(): Flow<List<String>> = flow {
        listOf("01", "02")
    }

    fun save(res: List<String>) {}
}

// O Repository quem vai buscar os dados
class NewRepository(
    private val dispatcher: CoroutineDispatcher,
    private val apiService: ApiService,
    private val dao: FakeDao
) {
    val all = dao.getAll()

    private suspend fun save(res: List<String>) {
        // withContext muda a Thread que irá executar esse código
        // Dispatchers.IO faz operação I/O, como acessar banco de dados ou API
        withContext(dispatcher) {
            dao.save(res)
        }
    }

    suspend fun getAndStore() {
        val res = apiService.get()

        save(res)
    }
}

class ApiService {
    fun get(): List<String> = listOf("01", "02")
}

// Sempre deixe suas variáveis privadas
class BestPracticesViewModel(
    /*
        Nunca passe o context da Activity ou do Fragment, pois gera memory leak, já que a viewmodel tem o seu
        próprio ciclo de vida e não é destruido em rotação de tela, e a Activity/Fragment por sua vez
        fica atrelado a viewmodel e o garbage collector não remove essas instancias da memoria
    */
    // private val context: Context,

    /*
        Use Repository Pattern - Atua na camada de abstração entre lógica de negócios
        e a camada de acesso a dados
    */
    private val newRepository: NewRepository,

    /*
        Não passe diretamente a classe de serviço, seja Retrofit (Remota) ou ROOM (Local), a viewmodel
        não deve saber de onde está vindo os dados,
    */
    // private val apiService: ApiService,
) : ViewModel() {
    // viewModelScope.coroutineContext joga para o contexto Main
    // sempre crie classes puras quando estiver retornando objetos de um banco/api
    val allData: LiveData<List<String>> =
        newRepository.all.asLiveData(viewModelScope.coroutineContext)

    init {
        viewModelScope.launch {
            newRepository.getAndStore()
        }
    }
}