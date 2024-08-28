package template.app.launches.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Flickr(
    @SerialName("original")
    val original: List<String?>?,
)