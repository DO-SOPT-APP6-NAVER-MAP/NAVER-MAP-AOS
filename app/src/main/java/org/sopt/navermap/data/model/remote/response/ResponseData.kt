package org.sopt.navermap.data.model.remote.response

import kotlinx.serialization.Serializable
import org.sopt.navermap.presentation.model.DummyData

@Serializable
data class ResponseData(
    val status: Int,
    val message: String,
    val data: ResponseData,
) {
    @Serializable
    data class ResponseData(
        val id: Int,
        val name: String,
        val email: String,
    ) {
        fun toDummyData() = DummyData(
            id = id.toString(),
            email = email,
            name = name
        )
    }
}
