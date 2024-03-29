package mx.com.superheros.marvels.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.superheros.marvels.data.repository.CharacterRepository
import mx.com.superheros.marvels.data.model.Result

class HomeViewModel(private val repository: CharacterRepository) : ViewModel() {
    val characters = MutableLiveData<List<Result>>()

    fun fetchCharacters() {
        val ts = MarvelApiConfig.TS
        val publicKey = MarvelApiConfig.PUBLIC_KEY
        val hash = MarvelApiConfig.getHash()

        viewModelScope.launch {
            val response = repository.getCharacters(ts, publicKey, hash)
            characters.value = response.data.results
        }
    }
}
