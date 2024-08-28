package template.app.launches.repository

import template.app.launches.components.LaunchDTO
import template.app.launches.data.LaunchesRemoteService
import template.app.launches.data.model.LaunchesResponseItem

class LaunchesRepository(
    private val dataSource: LaunchesRemoteService
) {

    suspend fun fetchLaunches(): Result<List<LaunchDTO>> {
        try {
            val result = dataSource.fetch().map { item ->
                item.asDTO()
            }
            return Result.success(result)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }
}

fun LaunchesResponseItem.asDTO() = LaunchDTO(
    imageUrl = this.links?.patch?.large.orEmpty(),
    title = this.name.orEmpty(),
    description = this.details.orEmpty(),
    status = this.success == true,
    id = this.rocket.orEmpty()
)