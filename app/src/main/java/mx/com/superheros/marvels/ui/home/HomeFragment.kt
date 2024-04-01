package mx.com.superheros.marvels.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.superheros.marvels.R
import mx.com.superheros.marvels.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        val characterRecyclerView = binding.recyclerView
        characterRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val characterAdapter = CharacterAdapter()
        characterRecyclerView.adapter = characterAdapter

        viewModel.characters.observe(viewLifecycleOwner, { characters ->
            characterAdapter.submitList(characters)
        })

        val seriesRecyclerView = binding.seriesRecyclerView
        seriesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val seriesAdapter = SeriesAdapter()
        seriesRecyclerView.adapter = seriesAdapter

        viewModel.series.observe(viewLifecycleOwner, { series ->
            seriesAdapter.submitList(series)
        })

        viewModel.fetchCharacters()
        viewModel.fetchSeries()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}