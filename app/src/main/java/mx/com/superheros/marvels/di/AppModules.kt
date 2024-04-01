package mx.com.superheros.marvels.di

import mx.com.superheros.marvels.data.datasource.CharacterDataSource
import mx.com.superheros.marvels.data.datasource.RetrofitCharacterDataSource
import mx.com.superheros.marvels.data.datasource.RetrofitSeriesDataSource
import mx.com.superheros.marvels.data.datasource.SeriesDataSource
import mx.com.superheros.marvels.data.repository.CharacterRepository
import mx.com.superheros.marvels.data.repository.SeriesRepository
import mx.com.superheros.marvels.data.services.RetrofitService
import mx.com.superheros.marvels.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(RetrofitService::class.java) }
}

val dataSourceModule = module {
    single<CharacterDataSource> { RetrofitCharacterDataSource(get()) }
    single<SeriesDataSource> { RetrofitSeriesDataSource(get()) }
}

val repositoryModule = module {
    single { CharacterRepository(get()) }
    single { SeriesRepository(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
}

val appModules = listOf(networkModule, dataSourceModule, repositoryModule, viewModelModule)