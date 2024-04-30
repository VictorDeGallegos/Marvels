# Marvels 🕷️

<div align="center">
  
![marvel](https://github.com/VictorDeGallegos/Marvels/assets/41756950/1f73ab40-e622-43db-893f-96b5deb33fa6)

</div>

<div align="center">

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-purple?longCache=true&style=popout-square)](https://kotlinlang.org)
[![Android Studio](https://img.shields.io/badge/Android_Studio-Iguana-green.svg?longCache=true&style=popout-square)](https://developer.android.com/studio)
[![Android](https://img.shields.io/badge/Android-7.1+-green.svg?longCache=true&style=popout-square)](https://www.android.com)
[![Gradle](https://img.shields.io/badge/Gradle-8.1-blue.svg?longCache=true&style=popout-square)](https://gradle.org)

</div>


## Descripción 📝
Marvels App es una aplicación movil Android que consume la api oficial de [MARVEL](https://developer.marvel.com/) para poner en práctica el uso de patrones de diseño, el uso de una buena arquitectura siguiendo los principios SOLID.


## Arquitectura moderna y limpia de la aplicación 🏗️

Sigue las pautas de [arquitectura](https://developer.android.com/topic/architecture) oficiales proporcionadas por Google. Y está inspirado en [NowInAndroid](https://github.com/android/nowinandroid) de Google.

### **Capa de IU** 🖌️

| ![image](https://github.com/VictorDeGallegos/Marvels/assets/41756950/26365658-750f-4c5c-adfe-6a5c66524565) | La función de la capa de la IU (o capa de presentación) consiste en mostrar los datos de la aplicación en la pantalla. Cuando los datos cambian, ya sea debido a la interacción del usuario (como cuando presiona un botón) o una entrada externa (como una respuesta de red), la IU debe actualizarse para reflejar los cambios.<br><br>La capa de la IU consta de los siguientes dos elementos: - Contenedores de estados (como las clases `ViewModel`) que retienen datos, los exponen a la IU y controlan la lógica |
|---|---|

### **Capa de datos** 💾

| ![image](https://github.com/VictorDeGallegos/Marvels/assets/41756950/54dfad61-e376-4453-87b0-aa5f5fe2ab1a) | La capa de datos de la app contiene la lógica empresarial. Esta lógica es lo que le da valor a la app. Además, está compuesta por reglas que determinan cómo tu app crea, almacena y cambia datos.<br><br>La capa de datos está formada por repositorios que pueden contener de cero a muchas fuentes de datos. Por ejemplo, al crear una clase `CharacterRepository` para datos relacionados con los personajes o una clase `SeriesRepository` para datos relacionados con series. |
|---|---|


## Otras funciones útiles 🔧

- Esta versión brinda [Modularización](https://developer.android.com/topic/modularization)
- Diseños complejos de RecyclerView (con [Groupie](https://github.com/lisawray/groupie))
- Consumo de api [MARVEL](https://developer.marvel.com/) 
- Inyección de dependencias  (con [Koin](https://insert-koin.io/docs/quickstart/android/))
- Peticiones (con [Retrofit](https://square.github.io/retrofit/))
- Componentes de la arquitectura de Android para compartir ViewModels durante los cambios de configuración
- Google [Material Design](https://material.io/blog/android-material-theme-color) library

## Resumen + Diseño ✍🏻

![CoverMarvels](https://github.com/VictorDeGallegos/Marvels/assets/41756950/975c2426-c20d-4416-8a42-573a1780a4b4)

---
⌨️ con ❤️ por  [Victor Gallegos](https://github.com/VictorLiverpoolDev/VictorLiverpoolDev)
