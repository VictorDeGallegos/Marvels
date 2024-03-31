package mx.com.superheros.marvels.data.datasource

import mx.com.superheros.marvels.data.services.RetrofitService

class RetrofitCharacterDataSource(private val retrofitService: RetrofitService) : CharacterDataSource {
    override suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String) =
        retrofitService.getCharacters(ts, apiKey, hash, nameStartsWith, orderBy)
}