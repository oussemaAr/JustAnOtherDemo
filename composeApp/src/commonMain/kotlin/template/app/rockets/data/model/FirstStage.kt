package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirstStage(
    @SerialName("burn_time_sec")
    val burnTimeSec: Int?,
    @SerialName("engines")
    val engines: Int?,
    @SerialName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    @SerialName("reusable")
    val reusable: Boolean?,
)