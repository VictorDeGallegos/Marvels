package mx.com.superheros.marvels.application

import android.app.Application
import mx.com.superheros.marvels.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Inicializar Koin
        startKoin {
            // Configura el contexto de Android
            androidContext(this@MarvelsApplication)
            // Especifica los módulos de la aplicación
            modules(appModules)
        }
    }
}
