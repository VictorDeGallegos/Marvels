package mx.com.superheros.marvels.data.datasource

import mx.com.superheros.marvels.data.model.Result
import mx.com.superheros.marvels.data.services.RetrofitService

class RetrofitCharacterDataSource(private val retrofitService: RetrofitService) : CharacterDataSource {
    override suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String) =
        retrofitService.getCharacters(ts, apiKey, hash, nameStartsWith, orderBy)

    override suspend fun getCharacter(characterId: String, ts: String, apiKey: String, hash: String)  =
        retrofitService.getCharacter(characterId, ts, apiKey, hash)

    override suspend fun getComics(characterId: String, ts: String, apiKey: String, hash: String, orderBy: String) =
        retrofitService.getComics(characterId, ts, apiKey, hash, orderBy)
}