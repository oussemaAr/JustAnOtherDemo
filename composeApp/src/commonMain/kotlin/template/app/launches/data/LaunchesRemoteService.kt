package template.app.launches.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import template.app.launches.data.model.LaunchesResponseItem

class LaunchesRemoteService(
    private val client : HttpClient
) {

    suspend fun fetch(): List<LaunchesResponseItem> {
        return try {
            val response = client.get(urlString = "https://api.spacexdata.com/v4/launches")

            if (response.status == HttpStatusCode.OK) {
                response.body<List<LaunchesResponseItem>>()
            } else {
                throw Exception("Generale Error")
            }
        } catch (ex: Exception) {
            throw Exception("Serveur Error")
        }
    }
}