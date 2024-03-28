package mx.com.superheros.marvels.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.com.superheros.marvels.data.RetrofitServiceFactory
import mx.com.superheros.marvels.data.model.Result
import java.math.BigInteger
import java.security.MessageDigest

class HomeViewModel : ViewModel() {
    val characters = MutableLiveData<List<Result>>()

    fun fetchCharacters() {
        viewModelScope.launch {
            val service = RetrofitServiceFactory.makeRetrofitService()
            val ts = "1"
            val privateKey = "65c7252732a3f6c8fa83250af4b4cce289d8257f"
            val publicKey = "c1006cc1f9a5da0c85247f5245b469f2"
            val hash = generateHash(ts, privateKey, publicKey)
            val response = service.getCharacters(ts, publicKey, hash)
            characters.value = response.data.results
        }
    }

    private fun generateHash(ts: String, privateKey: String, publicKey: String): String {
        val input = ts + privateKey + publicKey
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}