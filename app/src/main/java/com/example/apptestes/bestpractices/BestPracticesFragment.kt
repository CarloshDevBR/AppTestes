package com.example.apptestes.bestpractices

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers

class BestPracticesFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = BestPracticesViewModel(
            newRepository = NewRepository(
                // Passe o contexto da aplicação que evita vazamento de memoria
                Dispatchers.IO,
                apiService = ApiService(),
                dao = FakeDao(requireContext().applicationContext)
            ),
        )
    }
}