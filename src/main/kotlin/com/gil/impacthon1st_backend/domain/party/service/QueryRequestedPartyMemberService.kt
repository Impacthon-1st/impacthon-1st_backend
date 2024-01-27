package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryRequestedPartyMemberResponse
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyRepository
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.stereotype.Service

@Service
class QueryRequestedPartyMemberService(
    private val partyJpaRepository: PartyJpaRepository,
    private val partyRepository: PartyRepository,
    private val partyMemberJpaRepository: PartyMemberJpaRepository,
    private val securityAdapter: SecurityAdapter,
) {

    fun execute(): QueryRequestedPartyMemberResponse {
        val currentUserId = securityAdapter.getCurrentUserId()
        return QueryRequestedPartyMemberResponse(partyRepository.queryPartyMembersByUserIdAndMeetAtIsAfterNow(currentUserId))
    }
}