package com.gil.impacthon1st_backend.domain.party.controller.dto.response

import com.querydsl.core.annotations.QueryProjection

data class QueryRequestedPartyMemberResponse(
    val partyMemberList: List<RequestedPartyMemberResponse>
)

data class RequestedPartyMemberResponse @QueryProjection constructor(
    val partyMemberId: Long,
    val profileImageUrl: String,
    val username: String,
)

