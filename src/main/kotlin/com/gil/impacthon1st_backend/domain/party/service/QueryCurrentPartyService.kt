package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryCurrentPartyResponse
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyRepository
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryCurrentPartyService(
    private val partyRepository: PartyRepository,
    private val securityAdapter: SecurityAdapter,
) {

    @Transactional(readOnly = true)
    fun execute(): QueryCurrentPartyResponse {
        val currentUserId = securityAdapter.getCurrentUserId()

        return partyRepository.queryPartiesByUserId(currentUserId)
            ?: throw NotFoundException("Party Not Found")
    }
}