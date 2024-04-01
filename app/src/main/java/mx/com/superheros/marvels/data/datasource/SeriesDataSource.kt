package mx.com.superheros.marvels.data.datasource

import mx.com.superheros.marvels.data.model.RemoteResult

interface SeriesDataSource {
    suspend fun getSeries(ts: String, apiKey: String, hash: String, titleStartsWith: String, orderBy: String): RemoteResult
}