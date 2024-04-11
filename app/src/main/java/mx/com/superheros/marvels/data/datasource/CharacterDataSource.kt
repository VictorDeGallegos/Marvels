package mx.com.superheros.marvels.data.datasource

import mx.com.superheros.marvels.data.model.RemoteResult
import mx.com.superheros.marvels.data.model.Result

interface CharacterDataSource {
    suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String): RemoteResult
    suspend fun getCharacter(
        characterId: String,
        ts: String,
        apiKey: String,
        hash: String,
    ): RemoteResult
}