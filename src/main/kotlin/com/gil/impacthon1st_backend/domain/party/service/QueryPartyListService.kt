package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryPartyListResponse
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryPartyListService(
    private val partyJpaRepository: PartyJpaRepository,
    private val partyRepository: PartyRepository,
    private val partyMemberJpaRepository: PartyMemberJpaRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryPartyListResponse =
        QueryPartyListResponse(partyRepository.queryPartiesByMeetAtIsAfterNow())
}