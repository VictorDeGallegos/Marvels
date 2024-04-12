package mx.com.superheros.marvels.data.model

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)