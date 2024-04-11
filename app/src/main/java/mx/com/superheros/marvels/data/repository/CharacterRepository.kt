package mx.com.superheros.marvels.data.repository

import mx.com.superheros.marvels.data.datasource.CharacterDataSource
import mx.com.superheros.marvels.data.model.Result

class CharacterRepository(private val dataSource: CharacterDataSource) {
    suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String) =
        dataSource.getCharacters(ts, apiKey, hash, nameStartsWith, orderBy)

    suspend fun getCharacter(characterId: String, ts: String, apiKey: String, hash: String) =
        dataSource.getCharacter(characterId, ts, apiKey, hash)
}