package mx.com.superheros.marvels.ui.detail

import MarvelApiConfig
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.data.repository.CharacterRepository

class DetailViewModel(private val repository: CharacterRepository, private val characterId: String) : ViewModel() {
    private val _character = MutableLiveData<Result>()
    val character: LiveData<Result> get() = _character

    init {
        loadCharacter()
    }

    private fun loadCharacter() {
        val characterId = characterId
        val ts = MarvelApiConfig.TS
        val publicKey = MarvelApiConfig.PUBLIC_KEY
        val hash = MarvelApiConfig.getHash()
        viewModelScope.launch {
            val character = repository.getCharacter(characterId, ts, publicKey, hash)
            _character.value = character.data.results.first()
        }
    }
}