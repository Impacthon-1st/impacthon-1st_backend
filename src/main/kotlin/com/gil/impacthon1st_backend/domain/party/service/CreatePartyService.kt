package com.gil.impacthon1st_backend.domain.party.service

import com.gil.impacthon1st_backend.domain.party.domain.Party
import com.gil.impacthon1st_backend.domain.party.domain.PartyMember
import com.gil.impacthon1st_backend.domain.party.controller.dto.request.CreatePartyRequest
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyJpaRepository
import com.gil.impacthon1st_backend.domain.party.domain.repository.PartyMemberJpaRepository
import com.gil.impacthon1st_backend.domain.user.controller.dto.request.CreateUserRequest
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreatePartyService(
    private val partyJpaRepository: PartyJpaRepository,
    private val partyMemberJpaRepository: PartyMemberJpaRepository,
    private val securityAdapter: SecurityAdapter,
    private val userJpaRepository: UserJpaRepository,
) {

    @Transactional
    fun execute(request: CreatePartyRequest) {
        val user = userJpaRepository.findByIdOrNull(securityAdapter.getCurrentUserId())
            ?: throw NotFoundException("User Not Found")

        val party = request.run {
            partyJpaRepository.save(
                Party(
                    meetAt = meetAt,
                    meetPlaceXPoint = meetPlaceXPoint,
                    meetPlaceYPoint = meetPlaceYPoint,
                    meetPlace = meetPlace,
                    count = count,
                    visitPlaceXPoint = visitPlaceXPoint,
                    visitPlaceYPoint = visitPlaceYPoint,
                    visitPlace = visitPlace,
                    content = content,
                    chatLink = chatLink,
                    user = user,
                )
            )
        }

        partyMemberJpaRepository.save(
            PartyMember(
                party = party,
                user = user,
            )
        )
    }
}