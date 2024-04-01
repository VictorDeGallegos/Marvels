package mx.com.superheros.marvels.data.datasource

import mx.com.superheros.marvels.data.services.RetrofitService

class RetrofitSeriesDataSource(private val retrofitService: RetrofitService) : SeriesDataSource {
    override suspend fun getSeries(ts: String, apiKey: String, hash: String, titleStartsWith: String, orderBy: String) =
        retrofitService.getSeries(ts, apiKey, hash, titleStartsWith, orderBy)
}