package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayloadWeight(
    @SerialName("id")
    val id: String?,
    @SerialName("kg")
    val kg: Int?,
    @SerialName("lb")
    val lb: Int?,
    @SerialName("name")
    val name: String?
)