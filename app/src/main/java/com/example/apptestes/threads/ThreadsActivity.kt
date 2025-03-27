package com.example.apptestes.threads

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apptestes.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ThreadsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_threads)

        // Para a Thread principal (UI Thread)
        // A UI Thread não deve ter nenhum tipo de processamento e sim somente atualizacação de dados
        repeat(5) { indice ->
            Log.i("running_thread", "Thread - $indice: ${Thread.currentThread().name}")
            Thread.sleep(1000)
        }

        // Minha Thread criada e startada
        MyThread {
            // runOnUiThread irá executar o código que refletirá na UI, já que a Thread criada não faz isso
            runOnUiThread {

            }
        }.start()

        // Runnable
        MyRunnable().start()

        // Scopes
        // MainScope executa na Thread principal
        MainScope().launch { }

        // GlobalScope executa na Thread IO
        GlobalScope.launch { }

        // runBlocking trava a Thread para executar
        runBlocking { }
    }
}