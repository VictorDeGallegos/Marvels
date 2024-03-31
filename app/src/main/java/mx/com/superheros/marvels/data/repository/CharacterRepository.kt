package mx.com.superheros.marvels.data.repository

import mx.com.superheros.marvels.data.datasource.CharacterDataSource

class CharacterRepository(private val dataSource: CharacterDataSource) {
    suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String) =
        dataSource.getCharacters(ts, apiKey, hash, nameStartsWith, orderBy)
}