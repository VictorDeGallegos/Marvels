package mx.com.superheros.marvels.data.services

import mx.com.superheros.marvels.data.model.RemoteResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("nameStartsWith") nameStartsWith: String,
        @Query("orderBy") orderBy: String
    ): RemoteResult

    @GET("series")
    suspend fun getSeries(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("titleStartsWith") titleStartsWith: String,
        @Query("orderBy") orderBy: String
    ): RemoteResult
}