package com.example.apptestes.android.toolbar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptestes.R
import com.example.apptestes.databinding.ActivityToolbarBinding

class ToolbarActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityToolbarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.materialToolbar.title = "Youtube"
        binding.materialToolbar.subtitle = "Teste teste"

        binding.materialToolbar.setTitleTextColor(
            ContextCompat.getColor(this, R.color.white)
        )

        binding.materialToolbar.inflateMenu(R.menu.menu)

        binding.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_01 -> {
                    return@setOnMenuItemClickListener true
                }

                R.id.item_02 -> {
                    return@setOnMenuItemClickListener true
                }

                else -> return@setOnMenuItemClickListener true
            }
        }

        // setSupportActionBar(binding.materialToolbar)

        // Adiciona botão de voltar
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}