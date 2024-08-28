package template.app.rockets.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SecondStage(
    @SerialName("burn_time_sec")
    val burnTimeSec: Int?,
    @SerialName("engines")
    val engines: Int?,
    @SerialName("fuel_amount_tons")
    val fuelAmountTons: Double?,
    @SerialName("payloads")
    val payloads: Payloads?,
    @SerialName("reusable")
    val reusable: Boolean?,
    @SerialName("thrust")
    val thrust: Thrust?
)