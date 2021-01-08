package `in`.techrova.kmmapplication.shared.repo

import `in`.techrova.kmmapplication.shared.data.model.RandomUser
import `in`.techrova.kmmapplication.shared.data.model.github.GitHubJob
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitHubRepo {
    val client: HttpClient = HttpClient()  {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    fun getJobByPage (page: Int, query: String) : Flow<List<GitHubJob>>
    {
        return flow {

            emit(client.get<List<GitHubJob>>("https://jobs.github.com/positions.json?description=$query&page=$page"))

        }
    }
}