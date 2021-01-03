package `in`.techrova.kmmapplication.shared

import `in`.techrova.kmmapplication.shared.data.model.RandomUser
import kotlin.jvm.JvmStatic
import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

expect class MathCalc {

    val client : HttpClient
    suspend fun getApi() : RandomUser

    companion object {
        @JvmStatic
        fun add(a: Int?, b: Int?): Int?
    }


}

actual class MathCalc {

    actual companion object {
        @JvmStatic
        actual fun add(a: Int?, b: Int?) : Int?
        {
            return b?.let { a?.plus(it) }
        }
    }

    actual val client: HttpClient = HttpClient()  {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }


    actual suspend fun getApi(): RandomUser {
        return  client.get<RandomUser>("https://randomuser.me/api/")
    }


}