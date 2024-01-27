package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EnterAgreePartyService(
    private val partyJpaRepository: PartyJpaRepository,
    private val partyMemberJpaRepository: PartyMemberJpaRepository,
    private val securityAdapter: SecurityAdapter,
) {

    @Transactional
    fun execute(partyMemberId: Long) {
        val currentUserId = securityAdapter.getCurrentUserId()

        val party = partyJpaRepository.findByUserId(currentUserId)
            ?: throw NotFoundException("Party Not Found")

        val partyMember = partyMemberJpaRepository.findByIdAndParty(partyMemberId, party)
            ?: throw NotFoundException("Party Member Not Found")

        partyMember.updateAgree(true)
    }
}