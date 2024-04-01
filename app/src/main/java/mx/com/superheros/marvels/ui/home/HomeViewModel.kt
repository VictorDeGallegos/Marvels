package mx.com.superheros.marvels.ui.home

import MarvelApiConfig
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.superheros.marvels.data.repository.CharacterRepository
import mx.com.superheros.marvels.data.repository.SeriesRepository
import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.util.Constants.IMAGE_NOT_FOUND_URL

class HomeViewModel(
    private val characterRepository: CharacterRepository,
    private val seriesRepository: SeriesRepository
) : ViewModel() {
    val characters = MutableLiveData<List<Result>>()
    val series = MutableLiveData<List<Result>>()

    fun fetchCharacters() {
        val ts = MarvelApiConfig.TS
        val publicKey = MarvelApiConfig.PUBLIC_KEY
        val hash = MarvelApiConfig.getHash()
        val nameStartsWith = MarvelApiConfig.NAME_STARTS_WITH
        val orderBy = MarvelApiConfig.ORDER_BY

        viewModelScope.launch {
            val response = characterRepository.getCharacters(ts, publicKey, hash, nameStartsWith, orderBy)
            val filteredCharacters = response.data.results.filter { it.thumbnail.path != IMAGE_NOT_FOUND_URL }
            characters.value = filteredCharacters
        }
    }

    fun fetchSeries() {
        val ts = MarvelApiConfig.TS
        val publicKey = MarvelApiConfig.PUBLIC_KEY
        val hash = MarvelApiConfig.getHash()
        val titleStartsWith = MarvelApiConfig.TITLE_STARTS_WITH
        val orderBy = MarvelApiConfig.ORDER_BY_SERIES

        viewModelScope.launch {
            val response = seriesRepository.getSeries(ts, publicKey, hash, titleStartsWith, orderBy)
            val filteredSeries = response.data.results.filter { it.thumbnail.path != IMAGE_NOT_FOUND_URL }
            series.value = filteredSeries
        }
    }
}