package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LandingLegs(
    @SerialName("number")
    val number: Int?
)