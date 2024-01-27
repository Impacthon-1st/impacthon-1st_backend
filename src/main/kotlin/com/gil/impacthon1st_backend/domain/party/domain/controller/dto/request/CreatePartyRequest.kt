package com.gil.impacthon1st_backend.domain.party.domain.controller.dto.request

import java.time.LocalDateTime

data class CreatePartyRequest(
    val meetAt: LocalDateTime,
    val meetPlaceXPoint: Float,
    val meetPlaceYPoint: Float,
    val meetPlace: String,
    val count: Int,
    val visitPlaceXPoint: Float,
    val visitPlaceYPoint: Float,
    val visitPlace: String,
    val content: String,
    val chatLink: String,
)