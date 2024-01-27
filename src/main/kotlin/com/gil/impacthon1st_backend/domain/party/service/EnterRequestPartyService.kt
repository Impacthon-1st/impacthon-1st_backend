package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.domain.PartyMember
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.ConflictException
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EnterRequestPartyService(
    private val partyJpaRepository: PartyJpaRepository,
    private val partyMemberJpaRepository: PartyMemberJpaRepository,
    private val userJpaRepository: UserJpaRepository,
    private val securityAdapter: SecurityAdapter,
) {

    @Transactional
    fun execute(partyId: Long) {
        val user = userJpaRepository.findByIdOrNull(securityAdapter.getCurrentUserId())
            ?: throw NotFoundException("User Not Found")
        val party = partyJpaRepository.findByIdOrNull(partyId)
            ?: throw NotFoundException("Party Not Found")
        val partyMembers = partyMemberJpaRepository.findAllByParty(party)

        if (partyMembers.map { it.user }.contains(user)) {
            throw ConflictException("Already Enter")
        }

        if (party.count <= partyMembers.size) {
            throw ConflictException("Full Party Member")
        }

        partyMemberJpaRepository.save(
            PartyMember(
                party = party,
                user = user,
                agree = false,
            )
        )
    }
}