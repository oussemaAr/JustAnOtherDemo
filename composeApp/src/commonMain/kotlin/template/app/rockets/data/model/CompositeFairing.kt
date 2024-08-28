package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompositeFairing(
    @SerialName("diameter")
    val diameter: Diameter?,
    @SerialName("height")
    val height: HeightX?
)