package mx.com.superheros.marvels.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.superheros.marvels.R
import mx.com.superheros.marvels.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = CharacterAdapter()
        recyclerView.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            adapter.submitList(characters)
        })

        viewModel.fetchCharacters()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}