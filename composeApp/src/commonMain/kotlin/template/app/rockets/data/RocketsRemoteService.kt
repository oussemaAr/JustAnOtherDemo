package template.app.rockets.data

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import template.app.rockets.data.model.RocketDetailsReponse

class RocketsRemoteService(
    private val client: HttpClient
) {

    suspend fun fetchRocketDetails(id: String): RocketDetailsReponse {
        try {
            val result = client.get(urlString = "https://api.spacexdata.com/v4/rockets/$id")
            if (result.status == HttpStatusCode.OK) {
                return result.body()
            } else {
                throw Exception("Rocket Not Found")
            }
        } catch (ex: Exception) {
            Napier.e(ex.message.orEmpty())
            throw Exception("Server Error")
        }
    }
}