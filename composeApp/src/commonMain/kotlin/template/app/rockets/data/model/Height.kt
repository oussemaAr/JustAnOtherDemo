package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Height(
    @SerialName("feet")
    val feet: Int?,
    @SerialName("meters")
    val meters: Double?
)