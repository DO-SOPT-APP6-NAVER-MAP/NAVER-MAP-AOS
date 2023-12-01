package org.sopt.navermap.data.model.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRoute(
    @SerialName("statusCode")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("directionLists")
        val directionLists: List<DirectionLists>
    )
}
@Serializable
data class DirectionLists(
    @SerialName("directionId")
    val directionId: Long,
    @SerialName("route")
    val route: String
)