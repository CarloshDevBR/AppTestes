package com.example.apptestes.android.threads

import android.util.Log
import java.lang.Thread.currentThread
import java.lang.Thread.sleep

class MyRunnable : Runnable {
    private var isStopped = false

    override fun run() {
        if (isStopped) return

        Log.i("running_thread", "Thread: ${currentThread().name}")

        repeat(30) { indice ->
            Log.i("running_thread", "Thread - $indice: ${currentThread().name}")

            sleep(1000)
        }
    }

    fun start() {
        isStopped = false
    }

    fun stop() {
        isStopped = true
    }
}