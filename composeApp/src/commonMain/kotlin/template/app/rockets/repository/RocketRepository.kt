package template.app.rockets.repository

import io.github.aakira.napier.Napier
import template.app.rockets.data.RocketsRemoteService
import template.app.rockets.repository.entity.RocketDTO

class RocketRepository(
    private val service: RocketsRemoteService
) {

    suspend fun fetchRocketDetails(id: String): RocketDTO? {
       try {
           val result = service.fetchRocketDetails(id)
           return RocketDTO(
               result.type.orEmpty()
           )
       }catch (ex : Exception){
           Napier.e(ex.message.orEmpty())
           return null
       }
    }
}