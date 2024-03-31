import java.math.BigInteger
import java.security.MessageDigest

object MarvelApiConfig {
    const val TS = "1"
    const val PUBLIC_KEY = "c1006cc1f9a5da0c85247f5245b469f2"
    const val PRIVATE_KEY = "65c7252732a3f6c8fa83250af4b4cce289d8257f"
    const val NAME_STARTS_WITH = "spider"
    const val ORDER_BY = "modified"

    fun getHash(): String {
        val input = "$TS$PRIVATE_KEY$PUBLIC_KEY"
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        val hash = BigInteger(1, digest).toString(16)
        return hash.padStart(32, '0')
    }
}
