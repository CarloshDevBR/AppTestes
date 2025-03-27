package com.example.apptestes.android.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apptestes.databinding.FragmentConversationsBinding

class ConversationsFragment : Fragment() {
    private var _binding: FragmentConversationsBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.i("ciclo_de_vida", "Fragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("ciclo_de_vida", "Fragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.i("ciclo_de_vida", "Fragment onCreateView")

        _binding = FragmentConversationsBinding.inflate(inflater, container, false)

        loadArgs()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("ciclo_de_vida", "Fragment onViewCreated")
    }

    override fun onStart() {
        super.onStart()

        Log.i("ciclo_de_vida", "Fragment onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("ciclo_de_vida", "Fragment onResume")
    }

    override fun onPause() {
        Log.i("ciclo_de_vida", "Fragment onPause")

        super.onPause()
    }

    override fun onStop() {
        Log.i("ciclo_de_vida", "Fragment onStop")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.i("ciclo_de_vida", "Fragment onDestroyView")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("ciclo_de_vida", "Fragment onDestroy")

        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("ciclo_de_vida", "Fragment onDetach")

        super.onDetach()
    }

    fun loadArgs() {
        val arg = arguments?.getString("category") ?: ""

        binding.textConversations.text = arg
    }
}