package com.example.apptestes.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.apptestes.R
import com.example.apptestes.databinding.ActivityFragmentsBinding

class FragmentsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChamadas.setOnClickListener(this)
        binding.buttonConversas.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_chamadas -> {
                val bundle = bundleOf("category" to "shop")

                // commit da lib fragment-ktx pra facilitar o uso de fragments
                supportFragmentManager.commit {
                    replace<CallsFragment>(R.id.fragment_container_view, args = bundle)
                }
            }

            R.id.button_conversas -> {
                val conversationsFragment = ConversationsFragment()

                val bundle = bundleOf("category" to "tester")

                conversationsFragment.arguments = bundle

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, conversationsFragment)
                    .commit()
            }
        }
    }
}