package com.gil.impacthon1st_backend.domain.party.controller.dto.response

import com.gil.impacthon1st_backend.domain.user.domain.Gender
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime

data class QueryPartyListResponse(
    val partyList: List<PartyResponse>
)

data class PartyResponse @QueryProjection constructor(
    val partyId: Long,
    val visitPlaceName: String,
    val visitPlaceXPoint: Float,
    val visitPlaceYPoint: Float,
    val count: Int,
    val partyMemberCount: Long,
    val profileImageUrl: String,
    val username: String,
    val gender: Gender,
    val meetAt: LocalDateTime,
    val title: String,
    val content: String,
)

data class QueryCurrentPartyResponse @QueryProjection constructor(
    val partyId: Long,
    val visitPlaceName: String,
    val visitPlaceXPoint: Float,
    val visitPlaceYPoint: Float,
    val username: String,
    val profileImageUrl: String,
    val createdAt: LocalDateTime,
    val meetAt: LocalDateTime,
)