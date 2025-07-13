package com.example.apptestes.android.deeplink

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class DeepLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: Uri? = intent?.data
        data?.let {
            val parametro = it.getQueryParameter("id")
            Log.d("DEEPLINK", "Parametro: $parametro")
        }
    }
}