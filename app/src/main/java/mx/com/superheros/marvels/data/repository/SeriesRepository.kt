package mx.com.superheros.marvels.data.repository

import mx.com.superheros.marvels.data.datasource.SeriesDataSource

class SeriesRepository(private val dataSource: SeriesDataSource) {
    suspend fun getSeries(ts: String, apiKey: String, hash: String, titleStartsWith: String, orderBy: String) =
        dataSource.getSeries(ts, apiKey, hash, titleStartsWith, orderBy)
}