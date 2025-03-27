package com.example.apptestes.threads

import android.util.Log

class MyThread(private val onEndProcess: () -> Unit) : Thread() {
    override fun run() {
        super.run()

        Log.i("running_thread", "Thread - ${currentThread().name}")
    }

    override fun start() {
        super.start()

        repeat(5) { indice ->
            Log.i("running_thread", "Thread - $indice: ${currentThread().name}")

            sleep(1000)
        }

        onEndProcess()
    }
}