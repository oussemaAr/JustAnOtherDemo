package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mass(
    @SerialName("kg")
    val kg: Int?,
    @SerialName("lb")
    val lb: Int?
)