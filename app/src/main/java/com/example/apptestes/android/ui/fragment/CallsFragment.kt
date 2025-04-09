package com.example.apptestes.android.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apptestes.R
import com.example.apptestes.databinding.FragmentCallsBinding

class CallsFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentCallsBinding? = null
    private val binding get() = _binding!!
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCallsBinding.inflate(inflater, container, false)

        binding.buttonExec.setOnClickListener(this)

        loadCount()

        loadArgs()

        return binding.root
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_exec) {
            count++

            loadCount()
        }
    }

    private fun loadCount() {
        binding.textView.text = "chamadas $count"
    }

    private fun loadArgs() {
        val arg = arguments?.getString("category") ?: ""

        binding.textView2.text = arg
    }
}