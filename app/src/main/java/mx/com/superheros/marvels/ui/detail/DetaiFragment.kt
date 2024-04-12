package mx.com.superheros.marvels.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import mx.com.superheros.marvels.R
import mx.com.superheros.marvels.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel { parametersOf(args.characterId) }
    private val detailViewModelComics: DetailViewModel by viewModel { parametersOf(args.characterId) }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        detailViewModel.character.observe(viewLifecycleOwner) { character ->
            Glide.with(binding.root.context)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .into(binding.characterImage)

            binding.characterID.text = character.id.toString()
            binding.characterName.text = character.name
            // if the description is empty, show a default message
            if (character.description.isEmpty()) {
                binding.characterDescription.text = "No description available"
            } else {
                binding.characterDescription.text = character.description
            }
            binding.characterComics.text = getString(R.string.character_comics)
        }

        detailViewModelComics.comics.observe(viewLifecycleOwner) { comics ->
            val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
                addAll(comics.results.map { ComicItem(comics)})
            }
            binding.characterComicsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@DetailFragment.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = groupAdapter
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}