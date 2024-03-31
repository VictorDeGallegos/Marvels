package mx.com.superheros.marvels.data.datasource


import mx.com.superheros.marvels.data.model.RemoteResult


interface CharacterDataSource {
    suspend fun getCharacters(ts: String, apiKey: String, hash: String, nameStartsWith: String, orderBy: String): RemoteResult
}