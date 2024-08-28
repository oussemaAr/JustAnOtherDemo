package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Isp(
    @SerialName("sea_level")
    val seaLevel: Int?,
    @SerialName("vacuum")
    val vacuum: Int?
)