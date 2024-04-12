package mx.com.superheros.marvels.ui.detail

import MarvelApiConfig
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.superheros.marvels.data.model.DataX
import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.data.model.ResultX
import mx.com.superheros.marvels.data.repository.CharacterRepository

class DetailViewModel(private val repository: CharacterRepository, private val characterId: String) : ViewModel() {
    private val _character = MutableLiveData<Result>()
    private val _comics = MutableLiveData<DataX>()
    val character: LiveData<Result> get() = _character
    val comics: LiveData<DataX> get() = _comics

    init {
        loadCharacter()
        loadComics()
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

    private fun loadComics() {
        val characterId = characterId
        val ts = MarvelApiConfig.TS
        val publicKey = MarvelApiConfig.PUBLIC_KEY
        val hash = MarvelApiConfig.getHash()
        viewModelScope.launch {
            val comics = repository.getComics(characterId, ts, publicKey, hash, "title")
            _comics.value = DataX(
                count = comics.data.count,
                limit = comics.data.limit,
                offset = comics.data.offset,
                results = comics.data.results.map {
                    ResultX(
                        id = it.id,
                        title = it.title,
                        description = it.description,
                        resourceURI = it.resourceURI,
                        urls = it.urls,
                        series = it.series,
                        thumbnail = it.thumbnail,
                        stories = it.stories,
                        events = it.events,
                        format = null,
                        images = null,
                        isbn = null,
                        issn = null,
                        issueNumber = null,
                        modified = it.modified,
                        pageCount = null,
                        prices = null,
                        textObjects = null,
                        upc = null,
                        variantDescription = null,
                        variants = null,
                        characters = null,
                        collectedIssues = null,
                        collections = null,
                        creators = null,
                        dates = null,
                        diamondCode = null,
                        digitalId = null,
                        ean = null,
                    )
                },
                total = comics.data.total
            )
        }
    }
}