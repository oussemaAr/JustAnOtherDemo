package template.app.launches.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Failure(
    @SerialName("altitude")
    val altitude: Int?,
    @SerialName("reason")
    val reason: String?,
    @SerialName("time")
    val time: Int?
)