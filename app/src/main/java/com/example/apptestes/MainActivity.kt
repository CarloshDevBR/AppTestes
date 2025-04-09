package com.example.apptestes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // enableEdgeToEdge ocupa completamente o espaço da tela
        enableEdgeToEdge()

        // define o layout a ser utilizado
        setContentView(R.layout.activity_main)

        /*
            setOnApplyWindowInsetsListener define um ouvinte para quando as insets
            da janela forem aplicadas à View.
        */
        // findViewById está pegando a view com ID main no layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            /*
                insets.getInsets(WindowInsetsCompat.Type.systemBars()) obtém os espaços
                ocupados pelas barras do sistema
            */
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // v.setPadding aplica os insets como padding à View
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets
        }
    }
}