package mx.com.superheros.marvels

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import mx.com.superheros.marvels.data.RetrofitServiceFactory
import mx.com.superheros.marvels.databinding.ActivityMainBinding
import java.math.BigInteger
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val service = RetrofitServiceFactory.makeRetrofitService()

        val ts = "1"
        val privateKey = "65c7252732a3f6c8fa83250af4b4cce289d8257f"
        val publicKey = "c1006cc1f9a5da0c85247f5245b469f2"
        val hash = generateHash(ts, privateKey, publicKey)

        lifecycleScope.launchWhenCreated {
            val response = service.getCharacters(ts, publicKey, hash)
            val characters = response.data.results
            characters.forEach {
                Log.d("CharacterNames", it.name)
            }
        }
    }

    private fun generateHash(ts: String, privateKey: String, publicKey: String): String {
        val input = ts + privateKey + publicKey
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}