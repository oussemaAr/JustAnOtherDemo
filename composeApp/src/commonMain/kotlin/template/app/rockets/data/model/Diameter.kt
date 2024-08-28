package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Diameter(
    @SerialName("feet")
    val feet: Double?,
    @SerialName("meters")
    val meters: Double?
)